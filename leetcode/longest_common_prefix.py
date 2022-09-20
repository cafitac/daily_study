from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        answer = ""
        characters_of_index = []
        strs.sort(key=len)
        for i in range(len(strs[0])):
            characters_of_index.append(set([str[i] for str in strs]))

        for c_set in characters_of_index:
            if len(c_set) == 1:
                answer += c_set.pop()
            else:
                break
        return answer


if __name__ == '__main__':
    solution = Solution()
    assert solution.longestCommonPrefix(["flower", "flow", "flight"]) == "fl"
    assert solution.longestCommonPrefix(["dog", "racecar", "car"]) == ""
    assert solution.longestCommonPrefix(["cir", "car"]) == "c"
