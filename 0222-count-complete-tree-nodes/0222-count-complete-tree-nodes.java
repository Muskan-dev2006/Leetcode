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
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left,right);
    }
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right==null){
            return 1;
        }
        return 2*height(root);
    }
}