from typing import Optional, List

# 해시에 저장될 단위 노드
class HashNode:
    def __init__(self, key: str, idx: int, value: str, next_node=None):
        self.key = key
        self.idx = idx
        self.value = value
        self.next_node = next_node

# 커스텀 해시
class HashCustom:
    BUCKET_SIZE = 97

    # 생성자
    def __init__(self):
        self.bucket = [None] * HashCustom.BUCKET_SIZE

    # 삽입 및 업데이트
    def set_custom(self, key: str, value: str) -> None:
        # 각 문자열의 문자들의 아스키코드 값을 더한 값을 해시 함수에 인자로 넣는다.
        ascii_sum = sum(ord(char) for char in key)
        idx = ascii_sum % HashCustom.BUCKET_SIZE

        # 인덱스에 저장이 안 됐을 경우
        if self.bucket[idx] is None:
            self.bucket[idx] = HashNode(key, idx, value)
            return
        # 인덱스에 이미 저장이 되어있는 경우
        else:
            # 개별 체이닝 탐색 시작
            node = self.bucket[idx]

            while node is not None:
                # 만약 리스트의 노드 중 같은 key를 찾으면 업데이트
                if node.key == key:
                    node.value = value
                    return

                # 아니라면 가장 마지막 node에 연결 리스트 삽입
                if node.next_node is None:
                    node.next_node = HashNode(key, idx, value)
                    return

                node = node.next_node

    # 조회
    def get_custom(self, key: str) -> int:
        ascii_sum = sum(ord(char) for char in key)
        idx = ascii_sum % HashCustom.BUCKET_SIZE

        node = self.bucket[idx]

        while node is not None:
            # 만약 리스트의 노드 중 같은 key를 찾으면 반환
            if node.key == key:
                return node.value

            node = node.next_node

    # 삭제
    def delete_custom(self, key: str) -> None:
        ascii_sum = sum(ord(char) for char in key)
        idx = ascii_sum % HashCustom.BUCKET_SIZE

        node = self.bucket[idx]
        prev = None

        while node is not None:
            if node.key == key and prev is None:
                self.bucket[idx] = node.next_node
                return
            elif node.key == key and prev is not None:
                prev.next_node = node.next_node

            prev = node
            node = node.next_node

# test
custom_hash = HashCustom()

custom_hash.set_custom("one", "1")
print(custom_hash.get_custom("one"))

custom_hash.set_custom("eno", "eno")
print(custom_hash.get_custom("eno"))

custom_hash.set_custom("neo", "new_world")
print(custom_hash.get_custom("neo"))

custom_hash.delete_custom("eno")
print(custom_hash.get_custom("neo"))
print(custom_hash.get_custom("one"))

custom_hash.set_custom("two", "two")
print(custom_hash.get_custom("two"))