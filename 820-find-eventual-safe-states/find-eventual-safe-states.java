class Solution {

    public boolean reachTerminal(HashMap<Integer,List<Integer>> graph, int node, int[] state){
        if(state[node]==1)return false;
        if(state[node]==2)return true;
        if(!graph.containsKey(node)){
            state[node]=2;
            return true;
        }
        List<Integer> li = graph.get(node);
        if(li.isEmpty()){
            state[node]=2;
            return true;
        }
        state[node]=1;
        for(Integer nbr: li){
            if(state[nbr]==2)continue;
            if(!reachTerminal(graph,nbr,state))return false;
        }
        state[node]=2;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();

        for(int i=0;i<graph.length;i++){
            hmap.computeIfAbsent(i,k-> new ArrayList<>());
            List<Integer> li = hmap.get(i);
            for(Integer in : graph[i]){
                li.add(in);
            }
        }

        List<Integer> li = new ArrayList<>();
        int[] state = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(reachTerminal(hmap,i,state)){
                li.add(i);
            }
        }
        return li;
    }
}