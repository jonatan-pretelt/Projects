from UserStateStore import UserStateStore


class InMemoryStateStore(UserStateStore):

    def __init__(self):
        self._store = {}

    def get(self, user_id: str):
        return self._store.get(user_id)
    
    def set(self, user_id: str, state):
        self._store[user_id] = state

    def delete(self, user_id: str):
        self._store.pop(user_id, None)

    def items(self):
        return self._store.items()
