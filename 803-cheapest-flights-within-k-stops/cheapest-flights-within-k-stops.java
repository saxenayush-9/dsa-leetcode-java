class Solution {

    class Node{
        int node;
        int price;
        int stops;

        Node(int node, int price, int stops){
            this.node=node;
            this.price=price;
            this.stops=stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,List<int []>> graph = new HashMap<>();
        
        for(int[] flight: flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.computeIfAbsent(from,l-> new ArrayList<>()).add(new int[]{to,price});
        }

        int[][] dist = new int[n][k+2];
        for(int[] dis: dist){
            Arrays.fill(dis,Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b)->a.price-b.price);

        minHeap.add(new Node(src,0,0));

        while(!minHeap.isEmpty()){
            Node node = minHeap.remove();
            int stop = node.node;
            int price = node.price;
            int stops = node.stops;

            if(stop==dst)return price;

            if(!graph.containsKey(stop))continue;

            List<int[]> li = graph.get(stop);

            for(int[] arr: li){
                int nbr = arr[0];
                int nbrPrice = arr[1];

                int newNumberOfStops = stops+1;
                if(newNumberOfStops<=k+1){
                    if(nbrPrice+price<dist[nbr][newNumberOfStops]){
                        dist[nbr][newNumberOfStops]=nbrPrice+price;
                        minHeap.add(new Node(nbr,nbrPrice+price,newNumberOfStops));
                    }
                }
            }
        }
        return -1;
    }
}