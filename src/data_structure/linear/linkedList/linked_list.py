# node2 = ListNode(2)  # val=2, next=None
# node2를 선언한 채로
# node1 = LinkedNode(1, node1) 이렇게 하면
# node1의 다음 노드는 node2를 지정 # val=1, next=node2
# 별도로 val값이나 next값 없이 ListNode()만 하면 초기화된 값(0, None)으로 채워진 ListNode의 인스턴스가 생긴다

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next