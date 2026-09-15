class Solution {
    public int maxProfit(int[] prices) {

        int lowestPrice = prices[0];
        int highestProfit = 0;

        for (int price : prices){

            int currProfit = price - lowestPrice;

            highestProfit = Math.max(highestProfit, currProfit);
            lowestPrice = Math.min(lowestPrice, price);

        }

        return highestProfit > 0 ? highestProfit : 0;
        
    }
}
