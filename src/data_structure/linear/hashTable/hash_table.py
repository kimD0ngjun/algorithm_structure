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
    def __init__(self, bucket):
        self.bucket = [None] * HashCustom.BUCKET_SIZE

    # 삽입 및 업데이트
    def custom_set(self, key: str, value: str) -> None:
    # 각 문자열의 문자들의 아스키코드 값을 더한 값을 해시 함수에 인자로 넣는다.
        ascii_sum = sum(ord(char) for char in key)
        idx = ascii_sum % HashCustom.BUCKET_SIZE

        # 인덱스에 저장이 안 됐을 경우
        if self.bucket[idx: int] is None:
            self.bucket[idx: int] = value
            return
        else:
            if self.bucket[idx].key == key:
                self.bucket[idx].value = value
                return
            else:
                node = self.bucket[idx]
                while node is not None:
                    if node.key == key:
                        node.value = value
                        return
                    else:
                        node.next_node = HashNode(key, idx, value)

                    node = node.next_node

    # 조회

    # 삭제