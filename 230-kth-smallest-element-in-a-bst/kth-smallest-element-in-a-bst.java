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
    public void inorder(TreeNode root, List<Integer> li, int k){
        if(root==null || li.size()==k) return;
        inorder(root.left,li,k);
        li.add(root.val);
        inorder(root.right,li,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> li = new ArrayList<>();
        inorder(root,li,k);
        return li.get(k-1);
    }
}