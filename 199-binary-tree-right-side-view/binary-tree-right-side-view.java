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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li =new ArrayList<>();
        if(root==null)return li;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        while(!que.isEmpty()){
            TreeNode temp = que.remove();
            if(temp==null){
                if(que.size()>0){
                    que.add(null);
                }
            }
            else{
                if(que.peek()==null){
                    li.add(temp.val);
                }
                if(temp.left!=null){
                    que.add(temp.left);
                }
                if(temp.right!=null){
                    que.add(temp.right);
                }
            }
        }
        return li;
    }
}