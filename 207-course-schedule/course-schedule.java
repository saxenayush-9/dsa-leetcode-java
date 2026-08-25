class Solution {

    public boolean hasCycle(int node, HashMap<Integer,List<Integer>> graph, int[] state){
        if(state[node]==1)return true;
        if(state[node]==2)return false;

        state[node]=1;
        if(!graph.containsKey(node)){
            state[node]=2;
            return false;
        }
        List<Integer> li = graph.get(node);

        for(Integer nbr: li){
            if(state[nbr]==2)continue;
            if(hasCycle(nbr,graph,state))return true;
        }

        state[node]=2;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        for(int[] prerequisite:prerequisites){
            int from = prerequisite[0];
            int to = prerequisite[1];

            graph.computeIfAbsent(to,k->new ArrayList<>()).add(from);
        }

        int[] state = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(state[i]==0 && hasCycle(i,graph,state)){
                return false;
            }
        }
        return true;
    }
}