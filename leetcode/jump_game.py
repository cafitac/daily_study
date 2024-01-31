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


# ChatGPT solution
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_jump = 0  # 현재 위치에서의 최대 점프 거리
        n = len(nums)

        for i in range(n):
            # 현재 위치에서의 최대 점프 거리가 현재 위치를 넘어서면 갱신
            if i > max_jump:
                return False

            max_jump = max(max_jump, i + nums[i])

            # 마지막 위치에 도달 가능하면 True 반환
            if max_jump >= n - 1:
                return True

        return False


if __name__ == '__main__':
    s = Solution()
    assert s.canJump([2,3,1,1,4]) == True
    assert s.canJump([3,2,1,0,4]) == False
    assert s.canJump([0]) == True
    assert s.canJump([2,0,0]) == True
    assert s.canJump([5,9,3,2,1,0,2,3,3,1,0,0]) == True
