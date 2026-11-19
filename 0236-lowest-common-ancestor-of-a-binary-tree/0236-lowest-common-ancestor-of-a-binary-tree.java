/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p){
            return p;
        }
        if(root == q){
            return q;
        }

        TreeNode leftans = lowestCommonAncestor(root.left,p,q);
        TreeNode rightans = lowestCommonAncestor(root.right,p,q);

        if(leftans == null && rightans== null){
            return null;
        }

        if(leftans != null &&rightans== null){
            return leftans;
        }
         if(leftans == null &&rightans!= null){
            return rightans;
        }
        else{
            return root;
        }
    
    }

}