/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public void attachClone(Node node,  HashMap<Node,Node> cloneMap){
        if(node==null || node.neighbors.isEmpty()){
            return;
        }

        if(!cloneMap.get(node).neighbors.isEmpty())return;

        List<Node> nbrs = node.neighbors;
        Node clone = cloneMap.get(node);
        for(Node nbr : nbrs){
            clone.neighbors.add(cloneMap.get(nbr));
            attachClone(nbr,cloneMap);
        }
    }

    public void generateClone(Node node,  HashMap<Node,Node> clone){
        if(clone.containsKey(node)){
            return;
        } 

        clone.put(node,new Node(node.val));
        List<Node> nbrs = node.neighbors;
        if(nbrs.isEmpty())return;

        for(Node nbr : nbrs){
            generateClone(nbr,clone);
        }
    }

    public Node cloneGraph(Node node) {
        
        if(node==null)return null;

        List<Node> nbrs = node.neighbors;

        if(nbrs.isEmpty()){
            return new Node(node.val);
        }

        HashMap<Node,Node> cloneMap = new HashMap<>();

        generateClone(node,cloneMap);

        attachClone(node,cloneMap);

        return cloneMap.get(node);
    }
}