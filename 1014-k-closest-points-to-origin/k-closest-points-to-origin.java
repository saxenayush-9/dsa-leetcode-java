class Solution {
    class HeapNode{
        int index;
        double distance;
        HeapNode(int index,double distance){
            this.index=index;
            this.distance=distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<HeapNode> maxHeap = new PriorityQueue<>((a,b)->Double.compare(b.distance,a.distance));
        for(int i=0;i<n;i++){
            int x=points[i][0];
            int y=points[i][1];
            double distance = Math.sqrt((x*x)+(y*y));
            maxHeap.add(new HeapNode(i,distance));
            if(maxHeap.size()>k){
                maxHeap.remove();
            }
        }
        int[][] res = new int[maxHeap.size()][2];
        for(int i=0;i<res.length;i++){
            res[i]=points[maxHeap.remove().index];
        }
        return res;
    }
}