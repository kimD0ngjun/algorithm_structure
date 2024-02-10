from typing import Optional, List

# 해시에 저장될 단위 노드
class HashNode:
    def __init__(self, idx: int, value: str, next_node=None):
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
    def set_hash(self, key: str, value: str) -> None:
    # 각 문자열의 문자들의 아스키코드 값을 더한 값을 해시 함수에 인자로 넣는다.
        ascii_sum = sum(ord(char) for char in key)
        index = ascii_sum % HashCustom.BUCKET_SIZE
        self.bucket[index: int] = value

    # 조회

    # 삭제