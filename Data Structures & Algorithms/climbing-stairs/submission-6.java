class Solution {
    public int climbStairs(int n) {

        int[] stepsClimbed = new int[n + 1];

        int first = 1;
        int second = 1;

        stepsClimbed[0] = 1;
        stepsClimbed[1] = 1;

        for (int i = 1; i < n; i++){

            int temp = first;
            first = first + second;
            second = temp;

        }

        return first;

        // This works because in our loop we really only use the last two indexes in the array
        // So we init first and second with 1 and use the same formula (first + second)

        // This gives us O(1) Space complexity and O(n) time complexity
        
    }
}
