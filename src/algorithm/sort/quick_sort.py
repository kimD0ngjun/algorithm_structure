"""
* 퀵 정렬 *
분할 알고리즘(split) : pivot을 기준으로 left와 right로 나눔
"""
class quick_sort:
    def __init__(self, arr):
        self.arr = arr
        # pivot은 재귀함수의 지역변수로 둔다

    def sort(self):
        self.divide(0, len(self.arr) - 1)
        return self.arr

    # initially low_idx = 0, high_idx = len(arr) - 1
    def divide(self, low_idx, high_idx):
        # extraordinary case
        if low_idx >= high_idx:
            return

        pivot = self.arr[low_idx]
        left = low_idx + 1
        right = high_idx

        # 여기서 pivot 기준 left와 right 교환 작업 수행
        while True:
            # left는 pivot보다 큰 값이 등장할 때까지 포인터를 오른쪽으로 이동시킨다
            while left <= right and self.arr[left] <= pivot:
                left += 1
            # right는 pivot보다 작은 값이 등장할 때까지 포인터를 왼쪽으로 이동시킨다
            while left <= right and self.arr[right] >= pivot:
                right -= 1

            # 포인터 무빙이 완료됐을 때,
            # left가 가리키는 놈은 pivot보다 크고 right가 가리키는 놈은 pivot보다 작다
            if left > right:
                # left > right라는 건, 왼쪽 구간은 모두 pivot 이하, 오른쪽은 모두 pivot 이상으로 이미 정렬된 상태
                """
                pivot을 기준으로 왼쪽과 오른쪽을 스왑하는 과정이 있었을 테고 거기서 left와 right가 크로스하게 되는 경우로 넘어가면 
                이제 이미 앞전에서 왼쪽은 pivot보다 작은 애들, 오른쪽은 pivot보다 큰 애들이 전부 배치(정렬이 아닌)가 됐을 테니 break 한다는 뜻
                """
                break
            else:
                self.arr[left], self.arr[right] = self.arr[right], self.arr[left]

        # 그리고 교환 작업이 끝나면, 업데이트된 right와 pivot(arr[low_idx])의 위치를 교체한다
        self.arr[low_idx], self.arr[right] = self.arr[right], self.arr[low_idx]

        # conquer
        self.divide(low_idx, right - 1)
        self.divide(right + 1, high_idx)

arr = [38, 27, 43, 3, 9, 82, 10]
quick_sort = quick_sort(arr)
print(quick_sort.sort())
