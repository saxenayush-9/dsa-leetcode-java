class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<double []> maxHeap = new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        int n = position.length;
        for(int i=0;i<n;i++){
            double[] arr = new double[2];
            arr[0]=position[i];
            arr[1]=(double)(target-position[i])/speed[i];
            maxHeap.add(arr);
        }
        int fleets = 1;
        double curr = maxHeap.remove()[1];
        while(maxHeap.size()>0){
            double temp = maxHeap.remove()[1];
            if(temp<=curr){
                continue;
            }
            else{
                fleets++;
                curr=temp;
            }
        }
        return fleets;
    }
}