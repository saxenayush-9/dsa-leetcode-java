class Solution {
    class Node{
        int node;
        int time;
        Node(int node, int time){
            this.node=node;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<Node>> graph = new HashMap<>();

        for(int[] time: times){
            int from = time[0];
            int to = time[1];
            int curTime = time[2];

            graph.computeIfAbsent(from,l-> new ArrayList<>()).add(new Node(to,curTime));
        }

        int[] minTime = new int[n+1];
        Arrays.fill(minTime,Integer.MAX_VALUE);

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b)-> a.time-b.time);
        minHeap.add(new Node(k,0));
        minTime[k]=0;

        while(!minHeap.isEmpty()){
            Node curNode = minHeap.remove();
            int from = curNode.node;
            int time = curNode.time;

            if (time > minTime[from]) continue;
            if(!graph.containsKey(from))continue;

            List<Node> nbrs = graph.get(from);

            for(Node nbrNode : nbrs){
                int nbr = nbrNode.node;
                int nbrTime = nbrNode.time;

                int newTime = time+nbrTime;
                if(newTime<minTime[nbr]){
                    minTime[nbr]=newTime;
                    minHeap.add(new Node(nbr,newTime));
                }
            }
        }

        int res=Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            res = Math.max(res,minTime[i]);
        }

        return res==Integer.MAX_VALUE?-1:res;
    }
}