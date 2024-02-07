from typing import List


class BinaryMaxHeap:
    def __init__(self):
        self.items = [None]
    
    # 삽입 과정
    def insert(self, k):
        self.items.append(k)
        self._percolate_up()
        
    def _percolate_up(self):
        cur = len(self.items) - 1
        # 새로운 값 추가되고 바로 직속 부모랑 인덱스 비교 작업
        parent = cur // 2
        
        while parent > 0: # 꼭대기 부모까지 닿을 때까지 작업 반복
            if self.items[cur] > self.items[parent]:
                # 자식이 부모보다 크면 스왑을 일으켜야 한다
                self.items[cur], self.items[parent] = self.items[parent], self.items[cur]
            
            # 현재 인덱스를 부모 인덱스로 끌어올리고
            cur = parent
            # 부모 인덱스는 다시 한 칸 위로 올라간다
            parent = cur // 2

    # 추출 과정
    def extract(self):
        if len(self.item) < 2:
            return None
        
        # 꼭대기에 있는 최대값
        root = self.items[1]

        # 꼭대기에 있는 최대값과 맨 끝에 있는 값들 중 하나랑 스왑
        self.items[1] = self.items[-1]

        # 최대값 추출
        self.items.pop()

    def _percolate_down(self, cur):
        # 뜬금없이 꼭대기로 올려졌으니 제자리 찾아가야함
        # 역시 인덱스 단위로 추적
        biggest = cur

        left = 2 * cur
        right = 2 * cur + 1

        # 왼쪽 바로 밑 혹은 오른쪽 바로 밑과 크기 비교해서 삼각형 영역 내의 최대값 크기 지정
        if left <= len(self.items) - 1 and self.items[left] > self.items[biggest]:
            biggest = left

        if right <= len(self.items) - 1 and self.items[right] > self.items[biggest]:
            biggest = right

        # 스왑이 일어나면서 어떻게 보면 꼭대기값에 새로운 값이 삽입된 거와 같은 상황
        if biggest != cur:
            # 우선 바뀐 애들 스왑해주면서 최대값 먼저 올려주고
            self.items[cur], self.items[biggest] = self.items[biggest], self.items[cur]
            
            # 내려간 애는 다시 제자리 찾아가기(삽입 과정)
            self._percolate_down(biggest)