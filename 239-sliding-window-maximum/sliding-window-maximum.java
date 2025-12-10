class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        int index =0;
        for(int i=0;i<nums.length;i++){
            if(!dque.isEmpty() && dque.getFirst()==i-k){
                dque.removeFirst();
            }
            while(!dque.isEmpty() && nums[dque.getLast()]<=nums[i]){
                dque.removeLast();
            }
            dque.addLast(i);
            if(i>=k-1){
                res[index]=nums[dque.getFirst()];
                index++;
            }
        }
        return res;
    }
}