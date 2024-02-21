class MergeSort:
    def __init__(self, array):
        self.array = array

    def merge_sort(self):
        self.sort(0, len(self.array) - 1)
        return self.array

    def sort(self, low_index, high_index):
        # 탈출 조건
        if low_index == high_index:
            return

        # 가운데 인덱스 추출
        middle_index = (high_index + low_index) // 2

        # 재귀 호출
        self.sort(low_index, middle_index)
        self.sort(middle_index + 1, high_index)

        # 병합(재귀 회수) 단계에서 정리될 부분
        self.merge(low_index, middle_index, high_index)

    # 별도의 배열화
    def merge(self, low_index, middle_index, high_index):
        temp = [0] * (high_index - low_index + 1)  # 임시로 담을 배열
        temp_index = 0  # 임시 배열 인덱스
        left_pointer = low_index  # 쪼갠 배열 중 한쪽 포인터
        right_pointer = middle_index + 1  # 쪼갠 배열 중 다른쪽 포인터

        # 각 포인터가 담당 배열의 마지막 인덱스까지 닿을 때까지 수행
        while left_pointer <= middle_index and right_pointer <= high_index:
            if self.array[left_pointer] <= self.array[right_pointer]:
                # 배열에 할당시킴과 동시에 변수 증가 업데이트(외워두기)
                temp[temp_index] = self.array[left_pointer]
                temp_index += 1
                left_pointer += 1
            else:
                temp[temp_index] = self.array[right_pointer]
                temp_index += 1
                right_pointer += 1

        # 한쪽 포인터가 먼저 다다랐을 때 수행
        while left_pointer <= middle_index:
            # 잔여 배열들 전부 붙여넣기
            temp[temp_index] = self.array[left_pointer]
            temp_index += 1
            left_pointer += 1

        # 얘도 마찬가지
        while right_pointer <= high_index:
            temp[temp_index] = self.array[right_pointer]
            temp_index += 1
            right_pointer += 1

        # 임시 배열의 내용을 원래 배열에 붙여넣기
        for i in range(len(temp)):
            self.array[low_index + i] = temp[i]

# 테스트
if __name__ == "__main__":
    array = [5, 2, 3, 1, 7, 4, 3, 8, 9]
    merge_sorter = MergeSort(array)
    sorted_array = merge_sorter.merge_sort()
    print(sorted_array)