from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> List:
        for idx in range(len(nums)-1, 0, -1):
            if nums[idx] == nums[idx-1]:
                nums.pop(idx-1)
        return nums


if __name__ == '__main__':
    solution = Solution()
    assert solution.removeDuplicates([1, 1, 2]) == [1, 2]
    assert solution.removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]) == [0, 1, 2, 3, 4]
