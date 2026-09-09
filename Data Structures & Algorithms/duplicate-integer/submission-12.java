class Solution {
    public boolean hasDuplicate(int[] nums) {

        if (nums.length == 0 || nums == null) return false;

        Set<Integer> seen = new HashSet<>();

        for (int curr : nums){

            if (seen.add(curr) == false) return true;

        }

        return false;
        
    }
}