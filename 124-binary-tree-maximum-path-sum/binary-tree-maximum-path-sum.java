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
    public int solve(TreeNode root, int[] arr) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            arr[0] = Math.max(arr[0], root.val);
            return root.val;
        }
        int leftSum = solve(root.left, arr);
        int rightSum = solve(root.right, arr);
        int sum = root.val;
        if (leftSum > 0)
            sum += leftSum;
        if (rightSum > 0)
            sum += rightSum;
        arr[0] = Math.max(arr[0], sum);
        return root.val+Math.max(0, Math.max(leftSum, rightSum));
    }

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        int[] arr = new int[1];
        arr[0] = Integer.MIN_VALUE;
        solve(root, arr);
        return arr[0];
    }
}