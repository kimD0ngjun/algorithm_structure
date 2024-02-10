# 해시에 저장될 단위 노드
class HashNode:
    def __init__(self, idx: int, value: str, next_node: 'HashNode' = None):
        self.idx = idx
        self.value = value
        self.next_node = next_node

# 커스텀 해시
class HashCustom:
    def __init__(self):
        pass