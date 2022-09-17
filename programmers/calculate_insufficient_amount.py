def solution(price, money, count):
    return max(0, (((price + price*count)) / 2 * count - money))


if __name__ == '__main__':
    assert solution(3, 20, 4) == 10
