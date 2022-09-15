def solution(citations):
    citations.sort(reverse=True)
    loop_range = list(reversed(range(max(citations)+1)))
    for i in loop_range:
        more_than_equals = [num for num in citations if num >= i]
        if len(more_than_equals) >= i and len(citations) - len(more_than_equals) <= i:
            return i


if __name__ == '__main__':
    assert solution([3, 0, 6, 1, 5]) == 3
    assert solution([6, 5, 5, 5, 3, 2, 1, 0]) == 4
