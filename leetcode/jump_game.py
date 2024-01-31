from typing import List


# My solution
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        nums.reverse()

        jump_count = 1

        for num in nums[1:]:
            if num >= jump_count:
                jump_count = 1
            else:
                jump_count += 1

        if jump_count == 1:
            return True
        else:
            return False


if __name__ == '__main__':
    s = Solution()
    assert s.canJump([2,3,1,1,4]) == True
    assert s.canJump([3,2,1,0,4]) == False
    assert s.canJump([0]) == True
    assert s.canJump([2,0,0]) == True
    assert s.canJump([5,9,3,2,1,0,2,3,3,1,0,0]) == True
