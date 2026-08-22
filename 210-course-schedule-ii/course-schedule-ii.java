class Solution {

    public boolean hasCycle( HashMap<Integer,List<Integer>> graph, int node, int[] state, List<Integer> list){
        if(state[node]==1)return true;
        if(state[node]==2)return false;
        state[node]=1;
        if(!graph.containsKey(node)){
            state[node]=2;
            list.add(node);
            return false;
        }
        List<Integer> li = graph.get(node);
        for(Integer nbr : li){
            if(state[nbr]==2)continue;
            if(hasCycle(graph,nbr,state,list)){
                return true;
            }
        }
        state[node]=2;
        list.add(node);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        if(prerequisites.length==0){
            for(int i=0;i<numCourses;i++){
                res[i]=i;
            }
            return res;
        }

        for(int[] course: prerequisites){
            int from = course[0];
            int to = course[1];

            graph.computeIfAbsent(to,k -> new ArrayList<>()).add(from);

        }

        int[] state = new int[numCourses];
        

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(state[i]==0 && hasCycle(graph,i,state,list)){
                return new int[]{};
            }
        }

        Collections.reverse(list);

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) list.add(i);
        }

        for (int i = 0; i < numCourses; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}