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

    def isValid2(self, s: str) -> bool:
        st = list()

        open_list = ["(", "[", "{"]
        close_list = [")", "]", "}"]

        for c in s:
            if c in open_list:
                st.append(c)
                continue

            if c in close_list:
                if st == [] or close_list.index(c) != open_list.index(st.pop()):
                    return False
        return st == []


if __name__ == '__main__':
    solution = Solution()
    assert solution.isValid("()") is True
    assert solution.isValid("()[]{}") is True
    assert solution.isValid("(]") is False
    assert solution.isValid("[") is False
    assert solution.isValid("]") is False

    assert solution.isValid2("()") is True
    assert solution.isValid2("()[]{}") is True
    assert solution.isValid2("(]") is False
    assert solution.isValid2("[") is False
    assert solution.isValid2("]") is False
