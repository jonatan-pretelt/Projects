from kafka import KafkaProducer
import json
import time

producer = KafkaProducer(
    bootstrap_servers="localhost:9092",
    value_serializer=lambda v: json.dumps(v).encode("utf-8")
)

events = [
    {"event": "user_signed_up", "user_id": 1},
    {"event": "user_updated", "user_id": 1},
    {"event": "user_deleted", "user_id": 1},
]

for event in events:
    producer.send("user_events", event)
    print(f"Produced: {event}")
    time.sleep(1)

producer.flush()
producer.close()
