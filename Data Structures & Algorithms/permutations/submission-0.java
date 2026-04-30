class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] chosen = new boolean[nums.length];
        backtrack(nums, chosen, result, new ArrayList<>());
        return result;
        
    }

    public void backtrack(int[] nums, boolean[] chosen, List<List<Integer>> result, List<Integer> curr){

        if (curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (chosen[i]) continue;

            curr.add(nums[i]);
            chosen[i] = true;

            backtrack(nums, chosen, result, curr);
            chosen[i] = false;
            curr.remove(curr.size() - 1);
        }

    }
}
