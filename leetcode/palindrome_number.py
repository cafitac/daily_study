class Solution:
    def isPalindrome(self, x: int) -> bool:
        return "".join(list(reversed(list(str(x))))) == str(x)


class Solution2:
    def isPalindrome(self, x: int) -> bool:
        return str(x)[::-1] == str(x)


class Solution3:
    def isPalindrome(self, x: int) -> bool:
        reversed_number = 0
        if x < 0 or (x % 10 == 0 and x != 0):
            return False

        while x > reversed_number:
            reversed_number = (reversed_number * 10) + (x % 10)
            x = x // 10
        return x == reversed_number or x == reversed_number // 10


if __name__ == '__main__':
    solution = Solution()
    assert solution.isPalindrome(121) is True
    assert solution.isPalindrome(-121) is False
    assert solution.isPalindrome(10) is False

    solution2 = Solution2()
    assert solution2.isPalindrome(121) is True
    assert solution2.isPalindrome(-121) is False
    assert solution2.isPalindrome(10) is False

    solution3 = Solution3()
    assert solution3.isPalindrome(121) is True
    assert solution3.isPalindrome(-121) is False
    assert solution3.isPalindrome(10) is False
