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
    Map<TreeNode,TreeNode>parent = new HashMap<>();
    Set<TreeNode>visited = new HashSet<>();
    List<Integer>ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        markParents(root,null);
        dfs(target,0,k);
        return ans;
    }
    public void markParents(TreeNode root, TreeNode prev){
        if(root == null){
            return;
        }
        parent.put(root, prev);
        markParents(root.left, root);
        markParents(root.right, root);
    }
    public void dfs(TreeNode root, int dist, int k){
        if(root == null || visited.contains(root)){
            return;
        }
        visited.add(root);
        if(dist == k){
            ans.add(root.val);
            return;
        }
        dfs(root.left,dist+1,k);
        dfs(root.right,dist+1,k);
        dfs(parent.get(root), dist+1, k);
    }
}