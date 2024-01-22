from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        for i in range(0, n):
            nums1[m + i] = nums2[i]

        nums1.sort()
        return nums1


if __name__ == '__main__':
    s = Solution()
    assert s.merge([1,2,3,0,0,0], 3, [2,5,6], 3) == [1,2,2,3,5,6]
    assert s.merge([1], 1, [], 0) == [1]
    assert s.merge([0], 0, [1], 1) == [1]
