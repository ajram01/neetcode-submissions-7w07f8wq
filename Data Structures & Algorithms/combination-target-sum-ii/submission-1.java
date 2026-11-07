class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> returnCombs = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(0, new ArrayList<>(), 0, returnCombs, target, candidates);
        
        return returnCombs;
    }

    private void dfs(int i, List<Integer> curr, int total, List<List<Integer>> returnCombs, int target, int[] candidates){

        if (total == target){
            returnCombs.add(new ArrayList<>(curr));
            return;
        }

        if ( i >= candidates.length || total > target){
            return;
        }

        // include candidate

        curr.add(candidates[i]);
        dfs(i + 1, curr, total + candidates[i], returnCombs, target, candidates);
        curr.remove(curr.size() - 1);

        // skip candidate

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }
        dfs(i + 1, curr, total, returnCombs, target, candidates);

    }
}
