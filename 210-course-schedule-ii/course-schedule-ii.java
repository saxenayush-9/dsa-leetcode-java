class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        boolean[] visiting = new boolean[n];
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] arr : prerequisites) {
            int a = arr[0];
            int b = arr[1];
            if (!graph.containsKey(a)) {
                List<Integer> li = new ArrayList<>();
                li.add(b);
                graph.put(a, li);
            } else {
                graph.get(a).add(b);
            }
        }
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            if (isCycle(graph, i, visited, visiting, li)) {
                return new int[] {};
            }
        }
        int[] res = new int[li.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = li.get(i);
        }
        return res;
    }

    public boolean isCycle(HashMap<Integer, List<Integer>> graph, int node, boolean[] visited, boolean[] visiting,
            List<Integer> list) {
        if (visiting[node])
            return true;
        if (visited[node])
            return false;
        if (!graph.containsKey(node)) {
            visited[node] = true;
            list.add(node);
            return false;
        }
        visiting[node] = true;
        List<Integer> li = graph.get(node);
        for (int i = 0; i < li.size(); i++) {
            if (visited[li.get(i)])
                continue;
            if (isCycle(graph, li.get(i), visited, visiting, list)) {
                return true;
            }
        }
        visiting[node] = false;
        visited[node] = true;
        list.add(node);
        return false;
    }
}