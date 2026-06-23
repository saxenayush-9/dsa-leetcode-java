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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)return list;
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> li = new ArrayList<>();
        que.add(root);
        que.add(null);
        while(!que.isEmpty()){
            TreeNode node = que.remove();
            if(node==null){
                if(!que.isEmpty()){
                    que.add(null);
                }
                list.add(new ArrayList<>(li));
                li.clear();
            }
            else{
                li.add(node.val);
                if(node.left!=null)que.add(node.left);
                if(node.right!=null)que.add(node.right);
            }
        }
        return list;
    }
}