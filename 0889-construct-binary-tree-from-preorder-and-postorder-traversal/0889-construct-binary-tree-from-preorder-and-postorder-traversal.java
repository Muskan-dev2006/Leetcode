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
    int preindex = 0;
    HashMap<Integer,Integer>map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        for(int i=0; i<postorder.length; i++){
            map.put(postorder[i],i);
        }

        return construct(preorder,postorder,0,postorder.length-1);
    }

    public TreeNode construct(int []preorder, int []postorder, int left, int right){
        if(left > right || preindex >= preorder.length){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preindex++]);

        if(left == right) return root;

        int nextroot = preorder[preindex];

        int mid = map.get(nextroot);

        root.left = construct(preorder,postorder,left,mid);
        root.right = construct(preorder,postorder,mid+1,right-1);

        return root;
    }

}