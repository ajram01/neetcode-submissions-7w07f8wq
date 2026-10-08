/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> leveledList = new ArrayList<>();

        if (root == null){
            return leveledList;
        }

        Deque<TreeNode> toProcess = new ArrayDeque<>();
        toProcess.offer(root);

        while (!toProcess.isEmpty()){

            int rowSize = toProcess.size();
            List<Integer> currRow = new ArrayList<>();

            for (int i = 0; i < rowSize; i++){

                TreeNode curr = toProcess.poll();
                currRow.add(curr.val);

                if (curr.left != null){
                    toProcess.offer(curr.left);
                }
                if (curr.right != null){
                    toProcess.offer(curr.right);
                }

            }

            leveledList.add(currRow);

        }

        return leveledList;
        
    }
}
