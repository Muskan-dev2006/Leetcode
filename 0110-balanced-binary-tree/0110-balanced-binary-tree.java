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
    public int height(TreeNode root){
        if(root == null) return -1;
        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);

        int diff = Math.abs(left-right);
        boolean curr = diff <= 1;

        boolean checkleft = isBalanced(root.left);
        boolean checkright = isBalanced(root.right);

        return curr && checkleft && checkright;
    }
}