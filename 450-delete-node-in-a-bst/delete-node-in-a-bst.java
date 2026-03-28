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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        TreeNode node = root;
        TreeNode parent  = null;
        while(node!=null && node.val!=key){
            parent = node;
            if(node.val<key){
                node=node.right;
            }
            else{
                node=node.left;
            }
        }
        if(node==null)return root;
        return delete(root,node,parent);
    }
    public TreeNode delete(TreeNode root, TreeNode node, TreeNode parent){
        if(node.left!=null && node.right!=null){
            TreeNode pred = node.left;
            TreeNode predParent = node;
            while(pred.right!=null){
                predParent = pred;
                pred=pred.right;
            }
            node.val=pred.val;
            node=pred;
            parent=predParent;
        }
        TreeNode child = node.left!=null?node.left:node.right;
        if(parent==null)return child;
        if(parent.left==node){
            parent.left=child;
        }
        else parent.right=child;
        return root;
    }
}