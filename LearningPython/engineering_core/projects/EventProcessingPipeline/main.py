from event_stream import event_stream
from processor import EventProcessor
from InMemoryUserStateStore import InMemoryStateStore

store = InMemoryStateStore()
processor = EventProcessor(store=store)

for event in event_stream():
    processor.process_event(event)

    print("Event counts:", processor.event_type_counts)
    print("User counts:", processor.store.items())

