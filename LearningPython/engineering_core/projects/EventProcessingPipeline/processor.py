from dataclasses import dataclass, field
from collections import Counter
from datetime import datetime, timezone, timedelta
from UserStateStore import UserStateStore

REQUIRED_EVENT_FIELDS = {"user_id", "type", "timestamp"}


@dataclass
class UserState:
    user_id: str
    total_events: int = 0
    event_types: Counter = field(default_factory=Counter)
    last_seen: datetime | None = None

    def record_event(self, event_type: str, event_timestamp: datetime):
        if not event_type:
            raise ValueError("event_type must be non-empty")
        
        if self.last_seen and event_timestamp < self.last_seen:
            raise ValueError("Events must be processed in order")
        
        self.total_events += 1
        self.event_types[event_type] += 1
        self.last_seen = event_timestamp

    def is_expired(self, now: datetime, ttl_seconds: int) -> bool:
        if self.last_seen is None:
            return False
        return (now - self.last_seen).total_seconds() > ttl_seconds



class EventProcessor:
    def __init__(
            self,
            *,
            store: UserStateStore,
            user_ttl_seconds: int = 300, #business rule
            cleanup_interval: int = 60, # seconds
                 ):
        # Core state
        self.event_type_counts: Counter[str] = Counter()
        self.store = store

        # cleanup config
        self.user_ttl_seconds = user_ttl_seconds
        self.cleanup_interval = timedelta(seconds = cleanup_interval)

        # cleanup bookkeeping
        self._last_cleanup: datetime | None = None

    def process_event(self, raw_event: dict):
        try:
            event = normalize_event(raw_event)
        except ValueError as e:
            print(f"Invalid event skipped: {e}")
            return

        user_id = event["user_id"]
        event_type = event["event_type"]
        timestamp = event["timestamp"]
        

        self.event_type_counts[event_type] += 1

        state = self.store.get(user_id)
        if state is None:
            state = UserState(user_id)
        
        state.record_event(
            event_type=event_type,
            event_timestamp=timestamp
        )

        self.store.set(user_id, state)
        self.maybe_cleanup(now=datetime.now(timezone.utc))

    def cleanup_expired_users(
            self, 
            *,
            now: datetime, 
            ttl_seconds: int) -> int:
        expired_users = [
            user_id
            for user_id, state in self.store.items()
            if state.is_expired(now, ttl_seconds)
        ]

        for user_id in expired_users:
            self.store.delete(user_id)

        return len(expired_users)

    def maybe_cleanup(self, *, now: datetime):
        if self._last_cleanup is None:
            self._last_cleanup = now
            return

        if now - self._last_cleanup >= self.cleanup_interval:
            self.cleanup_expired_users(now = now, ttl_seconds=self.user_ttl_seconds)
            self._last_cleanup = now


def validate_event(event: dict):
    missing = REQUIRED_EVENT_FIELDS - event.keys()
    if missing:
        raise ValueError(f"Missing fields: {missing}")

def normalize_event(raw_event: dict) -> dict:
    validate_event(raw_event)
    return {
        "user_id" : raw_event["user_id"],
        "event_type": raw_event["type"],
        "timestamp": datetime.fromtimestamp(
            raw_event["timestamp"], tz=timezone.utc
            ),
    }