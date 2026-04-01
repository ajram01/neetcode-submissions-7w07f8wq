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
    public TreeNode invertTree(TreeNode root) {

        Queue<TreeNode> toProcess = new ArrayDeque<>();

        if (root == null) return null;

        toProcess.offer(root);

        while (!toProcess.isEmpty()){

            TreeNode curr = toProcess.poll();

            TreeNode temp = curr.left;

            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null){
                toProcess.offer(curr.left);
            }
            if (curr.right != null){
                toProcess.offer(curr.right);
            }

        }

        return root;
        
    }
}
