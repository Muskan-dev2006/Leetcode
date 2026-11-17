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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>sol = new ArrayList<>();
        if(root==null){
            return sol;
        }
        Queue<TreeNode>q = new LinkedList<>();
        int count = 0;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer>ans = new ArrayList<>();
            for(int i=0; i<n; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }

                ans.add(curr.val);
            }
            if(count%2 == 0){
                sol.add(new ArrayList<>(ans));
            }
            else{
                Collections.reverse(ans);
                sol.add(ans);
            }
            count++;
        }
        return sol;
    }
}