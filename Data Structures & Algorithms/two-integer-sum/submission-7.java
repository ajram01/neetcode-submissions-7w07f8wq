class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> processed = new HashMap<>();

        for (int i = 0; i < nums.length; i++){

            int numNeeded = target - nums[i];

            if (processed.containsKey(numNeeded)){
                return new int[] {processed.get(numNeeded), i};
            }

            if (!processed.containsKey(nums[i])){
                processed.put(nums[i], i);
            }
        }

        return new int[] {};
        
    }
}
