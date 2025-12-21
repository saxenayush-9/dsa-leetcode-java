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
        que.add(root);
        que.add(null);
        List<Integer> li = new ArrayList<>();
        while(que.size()>0){
            TreeNode temp = que.remove();
            if(temp==null){
                if(que.size()>0){
                    que.add(null);
                }
                list.add(new ArrayList<>(li));
                li.clear();
            }
            else{
                li.add(temp.val);
                if(temp.left!=null)que.add(temp.left);
                if(temp.right!=null)que.add(temp.right);
            }
        }
        return list;
    }
}