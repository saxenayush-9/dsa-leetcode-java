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
    public int solve(TreeNode root,int preMax){
        if(root==null)return 0;
        int count = 0;
        if(root.val>=preMax){
            count++;
            preMax = root.val;
        }
        int leftCount = solve(root.left,preMax);
        int rightCount = solve(root.right,preMax);
        return leftCount+rightCount+count;
    }
    public int goodNodes(TreeNode root) {
        if(root==null)return 0;
        return solve(root,Integer.MIN_VALUE);
    }
}