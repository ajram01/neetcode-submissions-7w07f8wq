class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, 0, target, candidates, new ArrayList<>(), result);
        return result;        
    }

    public void backtrack(int start, int currSum, int target, int[] candidates, List<Integer> curr, List<List<Integer>> result){

        if (currSum == target){
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++){

            if (currSum + candidates[i] > target) break;

            if (i > start && candidates[i] == candidates[i - 1]) continue;

            curr.add(candidates[i]);

            backtrack(i + 1, currSum + candidates[i], target, candidates, curr, result);

            curr.remove(curr.size() - 1);
        }

    }
}
