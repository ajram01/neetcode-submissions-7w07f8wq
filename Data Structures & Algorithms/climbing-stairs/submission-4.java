class Solution {
    public int climbStairs(int n) {

        int[] stepsClimbed = new int[n + 1];

        stepsClimbed[0] = 1;
        stepsClimbed[1] = 1;

        for (int i = 2; i <= n; i++){

            stepsClimbed[i] = stepsClimbed[i - 1] + stepsClimbed[i - 2];
        }

        return stepsClimbed[n];
        
    }
}
