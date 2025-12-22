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
    public boolean isIdentical(TreeNode r1, TreeNode r2) {
        if(r1==null && r2==null)return true;
        if(r1==null || r2==null)return false;
        if(r1.val!=r2.val) return false;
        return isIdentical(r1.left,r2.left) && isIdentical(r1.right,r2.right);
        
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)return true;
        if(root==null || subRoot==null)return false;
        if(isIdentical(root,subRoot))return true;
        return (isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot));
    }
}