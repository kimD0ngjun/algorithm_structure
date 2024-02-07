# node2 = ListNode(2)  # val=2, next=None
# node2를 선언한 채로
# node1 = LinkedNode(1, node1) 이렇게 하면
# node1의 다음 노드는 node2를 지정 # val=1, next=node2
# 별도로 val값이나 next값 없이 ListNode()만 하면 초기화된 값(0, None)으로 채워진 ListNode의 인스턴스가 생긴다

# 중복 데이터 저장은 고려하지 않는다(귀찮아)
# 기타 예외 사항들은 고려하지 않는다(귀찮아)

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# 단방향 연결 리스트
class LinkedList:
    def __init__(self, head=None, tail=None):
        self.head = head
        self.tail = tail # 연결 리스트의 취지에 맞게

    # 출력 메소드
    def print_list(self):
        print_array = []

        node = self.head

        while(node):
            print_array.append(node.val)
            node = node.next

        print(print_array)

    # 추가 메소드
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

    # 삭제 메소드
    def delete(self, val):
        node = self.head

        # 삭제할 값이 처음 노드인 경우
        if node.val == val:
            if self.head == self.tail:
                # 연결 리스트에 노드가 하나만 있는 경우
                self.head = None
                self.tail = None
            else:
                # 연결 리스트에 노드가 여러 개 있는 경우
                self.head = self.head.next
            return

        # 삭제할 값이 처음 노드가 아닌 경우
        while node.next is not None:
            # 다음 노드가 삭제할 값을 가지고 있는지 확인
            if node.next.val == val:

                # 다음 노드를 삭제하고 연결을 재조정
                if node.next == self.tail:
                    # 삭제할 값이 꼬리 노드인 경우
                    self.tail = node

                node.next = node.next.next
                break

            node = node.next

test = LinkedList()
test.append(0)
test.print_list()
test.append(1)
test.print_list()
test.append(2)
test.print_list()

test.append(3)
test.append(4)
test.append(5)
test.append(6)
test.print_list()

test.delete(4)
test.print_list()