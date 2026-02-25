"""
Clean and validate raw user event records.

Rules:
- Required fields must exist
-user_id must be int
-event_type must be non-empty string
-timestamp must be present (no parsing yet)
-Invalid records should be skipped (not crash the pipeline)

"""

raw_events = [
    {"user_id": 123, "event_type": "click", "timestamp": "2024-01-01T10:00:00Z"},
    {"user_id": "abc", "event_type": "view", "timestamp": "2024-01-01T10:05:00Z"},
    {"event_type": "click", "timestamp": "2024-01-01T10:10:00Z"},
    {"user_id": 456, "event_type": "", "timestamp": "2024-01-01T10:15:00Z"},
]

from typing import List, Dict, Any


def clean_events(events: List[Dict[str, Any]]) -> List[Dict[str, Any]]:
    cleaned = []

    for event in events:
        # Validate required fields
        if (
            "user_id" not in event
            or "event_type" not in event
            or "timestamp" not in event
        ):
            continue

        # Validate types and values
        if not isinstance(event["user_id"], int):
            continue

        if not isinstance(event["event_type"], str) or not event["event_type"]:
            continue

        cleaned.append(event)

    return cleaned



