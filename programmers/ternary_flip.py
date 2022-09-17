def solution(n):
    rev_base = []

    while n > 0:
        n, mod = divmod(n, 3)
        rev_base.append(mod)

    rev_base.reverse()

    answer = 0
    for idx, x in enumerate(rev_base):
        answer += (3**idx) * x

    return answer


if __name__ == '__main__':
    assert solution(45) == 7
    assert solution(125) == 229
