class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxOnes = 0;
        int currLength = 0;

        for (int i = 0; i < nums.length; i++){

            if (nums[i] == 1){
                currLength++;
                maxOnes = Math.max(maxOnes, currLength);
            } else {
                currLength = 0;
            }
        }

        return maxOnes;
        
    }
}