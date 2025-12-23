/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()){
            TreeNode temp = que.remove();
            if(temp==null){
                sb.append("N,");
            }
            else{
                sb.append(temp.val+",");
                que.add(temp.left);
                que.add(temp.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;
        String[] st = data.trim().split(",");
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(st[0]));
        que.add(root);
        for(int i=1;i<st.length-1;i++){
            if(que.size()==0)break;
            TreeNode temp = que.remove();
            String leftStr = st[i];
            String rightStr = st[i+1];
            if(!leftStr.equals("N")){
                TreeNode left = new TreeNode(Integer.parseInt(leftStr));
                temp.left = left;
                que.add(left);
            }

            if(!rightStr.equals("N")){
                TreeNode right = new TreeNode(Integer.parseInt(rightStr));
                temp.right = right;
                que.add(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));