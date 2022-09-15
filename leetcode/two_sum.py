from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for idx, num in enumerate(nums):
            try:
                another_idx = nums.index(target - num)
                if idx == another_idx:
                    continue
                return [idx, another_idx]
            except ValueError:
                pass


if __name__ == "__main__":
    assert Solution().twoSum([2, 7, 11, 15], 9) == [0, 1]
    assert Solution().twoSum([3, 2, 4], 6) == [1, 2]
    assert Solution().twoSum([3, 3], 6) == [0, 1] or Solution().twoSum([3, 3], 6) == [1, 0]
    assert Solution().twoSum([0, 4, 3, 0], 0) == [0, 3] or Solution().twoSum([0, 4, 3, 0], 0) == [3, 0]
    assert Solution().twoSum([-1, -2, -3, -4, -5], -8) == [2, 4]
