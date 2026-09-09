class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);

        HashMap<Integer,Integer> freq = new HashMap<>();

        for(Integer i : nums){
            freq.compute(i,(key,val)-> val==null?1:val+1);
        }

        for(Integer i : freq.keySet()){
            minHeap.add(new int[] {i,freq.get(i)});
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }

        int[] res = new int[minHeap.size()];
        int index=0;
        
        for(int[] arr: minHeap){
            res[index]=arr[0];
            index++;
        }

        return res;
    }
}