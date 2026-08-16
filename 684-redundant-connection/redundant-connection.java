class Solution {
    public boolean dfs(HashMap<Integer,List<Integer>> graph, int from, int to, boolean[] visited){
        if(from==to)return true;
        visited[from]=true;
        List<Integer> li = graph.get(from);
        for(int i=0;i<li.size();i++){
            if(visited[li.get(i)])continue;
            if(dfs(graph,li.get(i),to,visited)){
                return true;
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            boolean[] visited = new boolean[edges.length+1];
            int from = edge[0];
            int to = edge[1];
            if(graph.containsKey(from) && graph.containsKey(to) && dfs(graph,from,to,visited)){
                return edge;
            }
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }
        return new int[]{};
    }
}