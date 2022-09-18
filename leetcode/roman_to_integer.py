class Solution:
    def __init__(self):
        self.symbols = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000,
        }

    def romanToInt(self, s: str) -> int:
        result = 0
        for idx, c in enumerate(s):
            if idx+1 < len(s) and self.symbols[c] < self.symbols[s[idx+1]]:
                continue
            if idx != 0 and self.symbols[s[idx-1]] < self.symbols[c]:
                result += self.symbols[c] - self.symbols[s[idx-1]]
                continue
            result += self.symbols[c]
        return result


if __name__ == '__main__':
    solution = Solution()
    assert solution.romanToInt("III") == 3
    assert solution.romanToInt("LVIII") == 58
    assert solution.romanToInt("XXVII") == 27
    assert solution.romanToInt("MCMXCIV") == 1994
