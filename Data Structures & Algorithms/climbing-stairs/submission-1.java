class Solution {
    public int climbStairs(int n) {

        if (n <= 2){
            return n;
        }

        int prev2 = 1;
        int prev1 = 2;
        int curr = 0;

        for (int i = 2; i < n; i++){

            curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;

        }

        return curr;

        // Time Complexity: O(n) we do the same work n times

        // Space Complexity: O(1) we create a few primitive vars
        
    }
}
