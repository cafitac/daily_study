from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        nums[:] = sorted(set(nums))
        return len(nums)


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 1

        while len(nums) > i:
            if nums[i] == nums[i-1]:
                nums.pop(i)
            else:
                target = nums[i]
                i += 1

        return len(nums)


if __name__ == '__main__':
    s: Solution = Solution()
    assert s.removeDuplicates([1,1,2]) == 2  # [1,2,_]
    assert s.removeDuplicates([0,0,1,1,1,2,2,3,3,4]) == 5  # [0,1,2,3,4,_,_,_,_,_]
    assert s.removeDuplicates([1,1]) == 1  # [0,1,2,3,4,_,_,_,_,_]
