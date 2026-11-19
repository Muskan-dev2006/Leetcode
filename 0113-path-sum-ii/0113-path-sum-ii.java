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
    List<List<Integer>>sol = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer>ans = new ArrayList<>();
        int sum = 0;
        solve(root,targetSum,ans,sum);
        return sol;
    }
    public void solve(TreeNode root, int target,List<Integer>ans, int sum){
        if(root == null){
            return;
        }
        sum += root.val;
        ans.add(root.val);
        if(root.left == null && root.right==null){
            if(target == sum){
                sol.add(new ArrayList<>(ans));
            }
        }
        solve(root.left,target,ans,sum);
        solve(root.right,target,ans,sum);
        ans.remove(ans.size()-1);
    }
}