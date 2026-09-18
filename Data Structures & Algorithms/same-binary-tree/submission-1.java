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

    boolean isSame = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {

        isSame = true;
        dfs(p, q);
        return isSame;
        
    }

    public void dfs(TreeNode a, TreeNode b){

        if (a == null && b == null) return;

        if (a == null && b != null || a != null && b == null || a.val != b.val){
            isSame = false;
            return;
        }

        dfs(a.left, b.left);
        dfs(a.right, b.right);

    }
}
