class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(Integer i : nums){
            minHeap.add(i);
            maxHeap.add(i);
        }

        int low=0;
        int high=n-1;
        int minLength = Integer.MAX_VALUE;

        while(low<=high){
            if(nums[low]<=minHeap.peek()){
                low++;
                minHeap.remove();
            }
            else if(nums[high]>=maxHeap.peek()){
                high--;
                maxHeap.remove();
            }
            else{
                minLength = Math.min(minLength,high-low+1);    
                break;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}