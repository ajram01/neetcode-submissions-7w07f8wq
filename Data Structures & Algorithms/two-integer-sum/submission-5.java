class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++){

            int numNeeded = target - nums[i];

            if (seen.containsKey(numNeeded) && seen.get(numNeeded) != i){
                return new int[] {seen.get(numNeeded), i};
            }

            seen.put(nums[i], i);

        }

        return new int[] {};
        
    }
}
