from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        for idx in range(len(nums) - 1, -1, -1):
            if nums[idx] == val:
                nums.pop(idx)
        return len(nums)


if __name__ == '__main__':
    solution = Solution()
    assert solution.removeElement([3, 2, 2, 3], 3) == 2
    assert solution.removeElement([0, 1, 2, 2, 3, 0, 4, 2], 2) == 5
