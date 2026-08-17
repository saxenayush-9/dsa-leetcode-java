class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        int count = 0;
        int n = isConnected.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    graph.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            dfs(graph,i,visited);
            count++;
        }
        return count;
    }

    public void dfs(HashMap<Integer,List<Integer>> graph, int node, boolean[] visited){
        if(node<0 || node>=visited.length) return;
        if(visited[node])return;
        visited[node]=true;
        if(!graph.containsKey(node))return;
        List<Integer> li = graph.get(node);
        
        for(Integer nbr: li){
            if(visited[nbr])continue;
            dfs(graph,nbr,visited);
        }
    }
}