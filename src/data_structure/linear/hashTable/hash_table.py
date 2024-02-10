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

    # 조회

    # 삭제