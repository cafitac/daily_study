from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        candidate = nums[0]
        count = 1

        for n in nums[1:]:
            if count == 0:
                candidate = n
                count = 1
            elif n == candidate:
                count += 1
            else:
                count -= 1

        return candidate


if __name__ == '__main__':
    s = Solution()
    assert s.majorityElement([3,2,3]) == 3
    assert s.majorityElement([2,2,1,1,1,2,2]) == 2
