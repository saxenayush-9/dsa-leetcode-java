class Solution {
    class Node{
        int to;
        int time;
        Node(int to, int time){
            this.to=to;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<Node>> graph = new HashMap<>();

        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        for(int[] time: times){
            int from = time[0];
            int to = time[1];
            int timeTaken = time[2];

            graph.computeIfAbsent(from,l-> new ArrayList<>()).add(new Node(to,timeTaken));
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);

        minHeap.add(new int[]{k,0});
        distance[k]=0;

        int ans = -1;

        while(!minHeap.isEmpty()){
            int[] arr = minHeap.remove();

            int node = arr[0];
            int time = arr[1];

            if (time > distance[node]) continue;

            if(!graph.containsKey(node))continue;

            List<Node> li = graph.get(node);

            for(Node q : li){
                if(distance[q.to]<=q.time+time)continue;
                distance[q.to]=q.time+time;
                minHeap.add(new int[]{q.to,q.time+time});
            }
        }

        for(int i=1;i<=n;i++){
            ans=Math.max(ans,distance[i]);
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}