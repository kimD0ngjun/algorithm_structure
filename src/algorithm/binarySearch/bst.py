
# 트리의 노드들
# 참조 값으로 간선 역할
# 원칙적으로 모든 노드 데이터 타입을 얻어야 하지만, 우선은 int 타입만
class Node:
    def __init__(self, value: int):
        self.value = value
        self.left = None
        self.right = None

# 이진탐색트리
class BinarySearchTree:
    def __init__(self):
        self.root = None

    """
    루트발 삽입
    """
    def insert(self, value: int) -> None:
        if self.root is None:
            self.root = Node(value)
        else:
            self.insert_node(self.root, value)

    # 부모 자식 단위에서 자식으로 넘겨주기
    def insert_node(self, node: Node, value: int) -> None:
        if value < node.value:
            if node.left is None:
                node.left = Node(value)
            else:
                self.insert_node(node.left, value)
        else:
            if node.right is None:
                node.right = Node(value)
            else:
                self.insert_node(node.right, value)

    """
    루트발 삭제
    """
    def delete(self, value: int) -> None:
        self.root = self.delete_node(self.root, value)

    # 삭제 재귀 단위
    def delete_node(self, node: Node, value: int):
        if node is None:
            return

        # 만약 삭제 노드가 현 노드보다 작으면
        if value < node.value:
            # 자연히 왼쪽으로 흘러가기
            node.left = self.delete_node(node.left, value)
        elif value > node.value:
            # 그 반대라면 오른쪽으로 흘러가기
            node.right = self.delete_node(node.right, value)

        # 만약 삭제할 노드를 발견했을 경우
        else:
            # 리프 노드(형제 없는 노드)면 바로 반환
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left

            # 두 자식 다 존재하면...
            # 삭제 대상 노드와 오른쪽 서브트리의 가장 왼쪽 노드(가장 작은 노드)와 위치 바꾸기
            # 위치 바뀐 삭제 대상 노드 거슬러 타고 올라가며 구조 조정
            temp_val = self.min_value_node(node.right)
            node.value = temp_val.value
            node.right = self.delete_node(node.right, temp_val.value)

        # 변경된 루트노드 반환
        return node


    """
    루트발 재귀호출 기반 최소값 탐색
    """
    def find_min(self):
        if self.root is None:
            return
        return self.min_value_node(self.root).value

    # 서브트리 기반 노드 탐색(최소)
    def min_value_node(self, node: Node) -> Node:
        current = node
        while current.left is not None:
            current = current.left
        return current

    """
    루트발 재귀호출 기반 최대값 탐색
    """
    def find_max(self):
        if self.root is None:
            return
        return self.max_value_node(self.root).value

    # 서브트리 기반 노드 탐색(최대)
    def max_value_node(self, node: Node) -> Node:
        current = node
        while current.right is not None:
            current = current.right
        return current

    def search(self, value: int) -> bool:
        return self.search_node(self.root, value)

    def search_node(self, node: Node, value: int) -> bool:
        if node is None:
            return False
        if node.value == value:
            return True
        elif value < node.value:
            return self.search_node(node.left, value)
        else:
            return self.search_node(node.right, value)


# 이진 탐색 트리 생성
bst = BinarySearchTree()

# 값 삽입
bst.insert(50)
bst.insert(30)
bst.insert(70)
bst.insert(20)
bst.insert(40)
bst.insert(60)
bst.insert(80)

# 최소값 및 최대값 탐색
print("Minimum value:", bst.find_min())  # 출력: 20
print("Maximum value:", bst.find_max())  # 출력: 80

# 값 검색
print("Search for 40:", bst.search(40))  # 출력: True
print("Search for 100:", bst.search(100))  # 출력: False

# 값 삭제
bst.delete(30)

# 삭제된 값이 있는지 다시 검색
print("Search for 30:", bst.search(30))  # 출력: False
