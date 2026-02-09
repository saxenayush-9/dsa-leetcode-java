class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(Integer stone : stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size()>1){
            int y = maxHeap.remove();
            int x = maxHeap.remove();
            if(x!=y){
                maxHeap.add(y-x);
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}