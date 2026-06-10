class Solution {
    public void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++){

            int curr = nums.length - 1;
            int prev = curr - 1;

            while (curr != 0){

                int temp = nums[curr];
                nums[curr] = nums[prev];
                nums[prev] = temp;

                curr = prev;
                prev = curr - 1;

            }

        }


        
    }
}