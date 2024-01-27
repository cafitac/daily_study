from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        idx = 0

        if (len(nums) < 3):
            return len(nums)

        while len(nums) - 2 > idx:
            if nums[idx] == nums[idx+1] == nums[idx+2]:
                nums.pop(idx+2)
            else:
                idx += 1

        return len(nums)


if __name__ == '__main__':
    s = Solution()
    assert s.removeDuplicates([1,1,1,2,2,3]) == 5
    assert s.removeDuplicates([0,0,1,1,1,1,2,3,3]) == 7
