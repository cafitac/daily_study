def solution(n):
    if n == 1:
        return 1
    answer = 1

    for i in range(1, (n + 1) // 2 + 1):
        sum = 0
        while sum < n:
            sum += i
            i += 1
            if sum == n:
                answer += 1
    return answer


# Programmers 에 올라와있는 가장 인기있는 답안
def solution2(n):
    return len([x for x in range(1, n+1, 2) if n % x == 0])


if __name__ == '__main__':
    assert solution(15) == 4
    assert solution2(15) == 4
