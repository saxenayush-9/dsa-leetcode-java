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
    public int solve(TreeNode root,int[] arr){
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 1;
        int leftHeight = solve(root.left,arr);
        int rightHeight = solve(root.right,arr);
        int sum = leftHeight+rightHeight;
        arr[0]=Math.max(arr[0],sum);
        return 1+Math.max(leftHeight,rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 0;
        int[] arr = new int[1];
        solve(root,arr);
        return arr[0];
    }
}