class Solution {
    public int[] twoSum(int[] nums, int target) {

        int difference;
        Map<Integer, Integer> seenValue = new HashMap<>();
        
        for (int i = 0; i <= nums.length; i++){

            difference = target - nums[i];

            if (seenValue.containsKey(difference)){
                return new int[] {seenValue.get(difference), i};
            } else {
                seenValue.put(nums[i], i);
            }

        }

    return new int[] {};

    }
}
