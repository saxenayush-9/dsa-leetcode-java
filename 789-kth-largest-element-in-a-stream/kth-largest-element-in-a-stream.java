class KthLargest {
    PriorityQueue<Integer> minHeap;
    int size;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.size=k;
        int n = nums.length;
        for(Integer i : nums){
            minHeap.add(i);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>size){
            minHeap.remove();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */