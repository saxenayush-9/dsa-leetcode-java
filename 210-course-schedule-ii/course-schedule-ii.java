class Solution {

    public boolean hasCycle(HashMap<Integer,List<Integer>> graph, int node, int[] state, List<Integer> list){
        if(state[node]==1)return true;
        if(state[node]==2)return false;

        state[node]=1;

        if(!graph.containsKey(node)){
            state[node]=2;
            list.add(node);
            return false;
        }

        List<Integer> li = graph.get(node);

        for(Integer nbr: li){
            if(state[nbr]==2)continue;
            if(hasCycle(graph,nbr,state,list))return true;
        }
        list.add(node);
        state[node]=2;
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] pre: prerequisites){
            int from = pre[0];
            int to = pre[1];

            graph.computeIfAbsent(to,k-> new ArrayList<>()).add(from);
        }

        int[] state = new int[numCourses];

        List<Integer> list = new ArrayList<>();
        int[] res = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(state[i]==0 && hasCycle(graph,i,state,list)){
                return new int[] {};
            }
        }

        if(list.isEmpty()){
            for(int i=0;i<numCourses;i++){
                res[i]=i;
            }
            return res;
        }
        
        Collections.reverse(list);

        for(int i=0;i<numCourses;i++){
            if(!list.contains(i)){
                list.add(i);
            }
        }

        for(int i=0;i<numCourses;i++){
            res[i]=list.get(i);
        }

        return res;

    }
}