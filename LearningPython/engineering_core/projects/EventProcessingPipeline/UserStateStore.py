from abc import ABC, abstractmethod
from typing import Optional


class UserStateStore(ABC):

    @abstractmethod
    def get(self, user_id: str):
        pass

    @abstractmethod
    def set(self, user_id: str, state):
        pass

    @abstractmethod
    def delete(self, user_id: str):
        pass

    @abstractmethod
    def items(self):
        pass
