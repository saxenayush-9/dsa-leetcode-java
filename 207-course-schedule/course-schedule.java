class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n = prerequisites.length;

        if(n==0)return true;
        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        for(int[] course : prerequisites){
            int from = course[0];
            int to = course[1];
            graph.computeIfAbsent(to,k-> new ArrayList<>()).add(from);
        }
        
        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=visited
        
        
        for(int i=0;i<numCourses;i++){
            if(state[i]==0 && hasCycle(graph,i,state))return false;
        }
        return true;
    }

    public boolean hasCycle(HashMap<Integer,List<Integer>> graph, int node, int[] state){
        if(state[node]==1)return true;
        if(state[node]==2)return false;

        if(!graph.containsKey(node))return false;
        state[node]=1;
        List<Integer> li = graph.get(node);
        for(int nbr : li){
            if(hasCycle(graph,nbr,state))return true;
        }
        state[node]=2;
        return false;
    }
}