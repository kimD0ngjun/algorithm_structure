from typing import List


class BinarySearch:
    def search(self, nums: List[int], target: int) -> int:
        return self.binary_search(nums, target, 0, len(nums) - 1)

    def binary_search(self, nums, target, low_index, high_index):
        # 역전이 되어버리면 값이 존재하지 않음
        if low_index > high_index:
            return -1

        middle_index = (low_index + high_index) // 2

        # 중간값에 타겟이 검색되는지?
        if nums[middle_index] == target:
            return middle_index
        # 중간값에 타겟이 검색되지 않을 경우
        # 중간 인덱스를 +-1함으로써 검색 범위를 재귀 축소한다
        elif nums[middle_index] > target:
            return self.binary_search(nums, target, low_index, middle_index - 1)
        else:
            return self.binary_search(nums, target, middle_index + 1, high_index)