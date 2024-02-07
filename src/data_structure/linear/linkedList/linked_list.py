# node2 = ListNode(2)  # val=2, next=None
# node2를 선언한 채로
# node1 = LinkedNode(1, node1) 이렇게 하면
# node1의 다음 노드는 node2를 지정 # val=1, next=node2
# 별도로 val값이나 next값 없이 ListNode()만 하면 초기화된 값(0, None)으로 채워진 ListNode의 인스턴스가 생긴다

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# 단방향 연결 리스트
class LinkedList:
    def __init__(self, head=None, tail=None):
        self.head = head
        self.tail = tail # 연결 리스트의 취지에 맞게

    def append(self, val):
        new_node = ListNode(val)

        # 처음 노드를 추가할 경우
        if not self.head:
            self.head = new_node
            self.tail = new_node
            return

        # 기존의 꼬리에 덧붙이는 경우

        # 기존 꼬리 노드의 None이었던 next를 정해줘야 함
        self.tail.next = new_node
        # 새로운 꼬리 노드를 지정함
        self.tail = new_node