class Solution {
    public int maxProfit(int[] prices) {

        int lowestPrice = prices[0];
        int highestProfit = 0;

        for (int i = 1; i < prices.length; i++){

            int currProfit = prices[i] - lowestPrice;

            highestProfit = Math.max(highestProfit, currProfit);
            lowestPrice = Math.min(lowestPrice, prices[i]);

        }

        return highestProfit;
        
    }
}
