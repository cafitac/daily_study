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


# Best Solution 1
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # It is impossible to sell stock on first day, set -infinity as initial value for cur_hold
        cur_hold, cur_not_hold = -float('inf'), 0

        for stock_price in prices:
            prev_hold, prev_not_hold = cur_hold, cur_not_hold

            # either keep hold, or buy in stock today at stock price
            cur_hold = max(prev_hold, prev_not_hold - stock_price)

            # either keep not-hold, or sell out stock today at stock price
            cur_not_hold = max(prev_not_hold, prev_hold + stock_price)

        # maximum profit must be in not-hold state
        return cur_not_hold


# Best Solution 2
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        price_gain = []

        for idx in range(len(prices) - 1):
            if prices[idx] < prices[idx + 1]:
                price_gain.append(prices[idx + 1] - prices[idx])

        return sum(price_gain)


if __name__ == '__main__':
    s = Solution()
    assert s.maxProfit([7,1,5,3,6,4]) == 7
    assert s.maxProfit([1,2,3,4,5]) == 4
    assert s.maxProfit([7,6,4,3,1]) == 0
