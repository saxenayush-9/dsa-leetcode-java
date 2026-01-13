class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] arr : prerequisites){
            int a = arr[0];
            int b = arr[1];
            if(graph.containsKey(a)){
                graph.get(a).add(b);
            }
            else{
                List<Integer> li = new ArrayList<>();
                li.add(b);
                graph.put(a,li);
            }
        }
        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            if(isCycle(graph,i,visited,visiting))return false;
        }
        return true;
    }
    public boolean isCycle(HashMap<Integer,List<Integer>> graph, int node, boolean[] visited, boolean[] visiting){
        if(visiting[node])return true;
        if(!graph.containsKey(node)){
            visited[node]=true;
            return false;
        }
        visiting[node]=true;
        List<Integer> li = graph.get(node);
        for(int i=0;i<li.size();i++){
            if(visited[li.get(i)])continue;
            if(isCycle(graph,li.get(i),visited,visiting))return true;
        }
        visiting[node]=false;
        visited[node]=true;
        return false;
    }
}