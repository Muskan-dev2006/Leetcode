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
    int postindex;
    HashMap<Integer,Integer>map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postindex = postorder.length-1;

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return construct(inorder,postorder,0,inorder.length-1);
    }

    public TreeNode construct(int []inorder, int []postorder, int left, int right){
        if(left > right) return null;

        int rootval = postorder[postindex--];

        TreeNode root = new TreeNode(rootval);

        int mid = map.get(rootval);

        root.right = construct(inorder,postorder,mid+1,right);
        root.left = construct(inorder,postorder,left,mid-1);

        return root;

    }
}