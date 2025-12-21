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
    public TreeNode build(int[] inorder, int inStart,int inEnd, int[] preorder, int preStart, int preEnd, HashMap<Integer,Integer> hmap){
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int indexInOrder = hmap.get(root.val);
        root.left =  build(inorder,inStart,indexInOrder-1,preorder,preStart+1,preStart+(indexInOrder-inStart),hmap);
        root.right = build(inorder,indexInOrder+1,inEnd,preorder,preStart+(indexInOrder-inStart)+1,preEnd,hmap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hmap.put(inorder[i], i);
        }
        return build(inorder, 0, n - 1, preorder, 0, n - 1, hmap);
    }
}