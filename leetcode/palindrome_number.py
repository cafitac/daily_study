class Solution:
    def isPalindrome(self, x: int) -> bool:
        return "".join(list(reversed(list(str(x))))) == str(x)


if __name__ == '__main__':
    solution = Solution()
    assert solution.isPalindrome(121) is True
    assert solution.isPalindrome(-121) is False
    assert solution.isPalindrome(10) is False
