from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k = k % len(nums)
        for _ in range(k):
            nums.insert(0, nums.pop(-1))

        return nums


# Community solution
class Solution(object):
    def rotate(self, nums, k):
        if len(nums) == 0:
            return []
        if k == 0:
            return nums
        if len(nums)<k:
            nums[:] = Solution.rotate(self,nums,len(nums))
            nums[:] = Solution.rotate(self,nums,k-len(nums))
        nums.reverse()
        nums[:k] = reversed(nums[:k])
        nums[k:] = reversed(nums[k:])
        return nums


# Best solution
class Solution:
    def rotate(self, nums: List[int], k: int):
        n = len(nums)
        k = k % n
        nums[:] = nums[-k:] + nums[:-k]

        return nums


if __name__ == '__main__':
    s = Solution()
    assert s.rotate([1,2,3,4,5,6,7], 3) == [5,6,7,1,2,3,4]
    assert s.rotate([-1,-100,3,99], 2) == [3,99,-1,-100]
