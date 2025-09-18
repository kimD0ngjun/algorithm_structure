class merge_sort:
    def __init__(self, arr):
        self.arr = arr
        self.temp = [None] * len(arr) # buffer

    def sort(self):
        self.divide(0, len(self.arr) - 1)
        return self.arr

    def divide(self, low_idx, high_idx):
        # extraordinary case
        if low_idx >= high_idx:
            return

        # divide
        mid_idx = (low_idx + high_idx) // 2

        # conquer
        self.divide(low_idx, mid_idx)
        self.divide(mid_idx + 1, high_idx)

        self.merge(low_idx, mid_idx, high_idx)

    def merge(self, low, mid, high):
        temp_idx = 0
        left_pointer = low # left arr pointer
        right_pointer = mid + 1 # right arr pointer

        # sorting two divided arr
        while left_pointer <= mid and right_pointer <= high:
            if self.arr[left_pointer] <= self.arr[right_pointer]:
                self.temp[temp_idx] = self.arr[left_pointer]
                left_pointer += 1
                temp_idx += 1
            else:
                self.temp[temp_idx] = self.arr[right_pointer]
                right_pointer += 1
                temp_idx += 1

        # if one pointer arrived
        while left_pointer <= mid:
            self.temp[temp_idx] = self.arr[left_pointer]
            left_pointer += 1
            temp_idx += 1

        while right_pointer <= high:
            self.temp[temp_idx] = self.arr[right_pointer]
            right_pointer += 1
            temp_idx += 1

        # to arr from buffer
        # because of sorting partial arr for upper arr
        for i in range(temp_idx):
            self.arr[low + i] = self.temp[i]

arr = [38, 27, 43, 3, 9, 82, 10]
merge_sort = merge_sort(arr)
print(merge_sort.sort())
