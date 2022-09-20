class Solution:
    def isValid(self, s: str) -> bool:
        st = list()

        for c in s:
            if c in ["(", "[", "{"]:
                st.append(c)
                continue
            elif len(st) == 0:
                return False

            if c == ")":
                if st[-1] == "(":
                    st.pop()
                else:
                    return False
            elif c == "]":
                if st[-1] == "[":
                    st.pop()
                else:
                    return False
            elif c == "}":
                if st[-1] == "{":
                    st.pop()
                else:
                    return False
        return len(st) == 0


if __name__ == '__main__':
    solution = Solution()
    assert solution.isValid("()") is True
    assert solution.isValid("()[]{}") is True
    assert solution.isValid("(]") is False
    assert solution.isValid("[") is False
    assert solution.isValid("]") is False
