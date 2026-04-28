class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, target, 0, new ArrayList<>(), result);
        return result;
        
    }

    public void backtrack(int start, int[] nums, int target, int currSum, List<Integer> curr, List<List<Integer>> result){

        if (currSum == target){
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++){
            
            if (currSum + nums[i] > target) break;

            curr.add(nums[i]);

            backtrack(i, nums, target, currSum + nums[i], curr, result);

            curr.remove(curr.size() - 1);
        }
    }
}
