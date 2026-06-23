class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(Integer num : nums){
            if(!hmap.containsKey(num)){
                hmap.put(num,1);
            }
            else{
                hmap.put(num,hmap.get(num)+1);
            }
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(Integer key : hmap.keySet()){
            minHeap.add(new int[]{key,hmap.get(key)});
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            arr[i]=minHeap.remove()[0];
        }
        return arr;
    }
}