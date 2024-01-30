from typing import List


# My solution, Best solution
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        buy_price = prices[0]

        for price in prices[1:]:
            if buy_price > price:
                buy_price = price
            elif profit < price - buy_price:
                profit = price - buy_price

        return profit


# Popular solution
class Solution:
    class Solution:
        def maxProfit(self, prices: List[int]) -> int:
            profit = 0
            buy_price = prices[0]

            for price in prices[1:]:
                profit = max(profit, price - buy_price)
                buy_price = min(buy_price, price)

            return profi


if __name__ == '__main__':
    s = Solution()
    assert s.maxProfit([7, 1, 5, 3, 6, 4]) == 5
    assert s.maxProfit([7, 6, 4, 3, 1]) == 0
    assert s.maxProfit([2, 1, 2, 1, 0, 1, 2]) == 2
    assert s.maxProfit([2, 4, 1]) == 2
