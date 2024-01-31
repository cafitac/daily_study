from typing import List


# My solution
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        stock_price = None
        total_profit = 0

        for i, price in enumerate(prices[:-1]):
            # sell
            if stock_price is not None and stock_price <= price:
                total_profit += price - stock_price
                stock_price = None

            # buy
            if stock_price is None and prices[i] < prices[i+1]:
                stock_price = price

        if stock_price is not None:
            total_profit += prices[-1] - stock_price

        return total_profit


if __name__ == '__main__':
    s = Solution()
    assert s.maxProfit([7,1,5,3,6,4]) == 7
    assert s.maxProfit([1,2,3,4,5]) == 4
    assert s.maxProfit([7,6,4,3,1]) == 0
