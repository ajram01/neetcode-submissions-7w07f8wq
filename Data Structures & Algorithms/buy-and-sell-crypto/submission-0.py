class Solution:
    def maxProfit(self, prices: List[int]) -> int:


        max_profit = 0
        lowest_number = float('inf')

        for price in prices:

            lowest_number = min(lowest_number, price)
            max_profit = max(max_profit, price - lowest_number)

        return max_profit
           