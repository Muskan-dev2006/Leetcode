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
    public void addL(TreeNode root,List<Integer>ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        addL(root.left,ans);
        addL(root.right,ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
    
        List<Integer>ans = new ArrayList<>();
        if(root== null){
            return ans;
        }
        addL(root,ans);
        return ans;
    }
}