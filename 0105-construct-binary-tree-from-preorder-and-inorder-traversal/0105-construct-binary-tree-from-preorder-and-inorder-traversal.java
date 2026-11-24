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
    HashMap<Integer,Integer>map = new HashMap<>();
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,inorder,inorder.length-1);
    }

    public TreeNode build(int []preorder, int instart, int [] inorder, int inend){
        if(instart > inend){
            return null;
        }
        int rootval = preorder[preIndex++];
        TreeNode root = new TreeNode(rootval);

        int rootIndex = map.get(root.val);

        root.left = build(preorder,instart, inorder, rootIndex-1);
        root.right = build(preorder,rootIndex+1, inorder, inend);

        return root;
    }
}