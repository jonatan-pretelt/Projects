import time
import random


def event_stream():
    event_types = ["login", "logout", "purchase", "updated_profile"]
    users = ["user_1", "user_2", "user_3"]

    while True:
        yield {
            "type": random.choice(event_types),
            "user_id": random.choice(users),
            "timestamp": time.time()
        }

        time.sleep(1)

