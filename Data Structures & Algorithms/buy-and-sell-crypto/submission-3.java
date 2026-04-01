class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;
        int left = 0;

        for (int i = 1; i < prices.length; i++){

            if (prices[i] < prices[left]){
                left = i;
            } else {
                profit = Math.max(profit, prices[i] - prices[left]);
            }


        }

        return profit;
        
    }
}
