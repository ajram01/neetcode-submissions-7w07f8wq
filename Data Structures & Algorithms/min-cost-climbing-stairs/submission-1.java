class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int first = 0;
        int second = 0;

        int minCost = 0;


        for (int i = cost.length - 1; i >= 0; i--){

            minCost = cost[i] + Math.min(first, second);
            second = first;
            first = minCost;

        }

        return Math.min(minCost, second);
    }
}
