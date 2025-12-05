class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i]=stk.peek();
            }
            stk.push(i);
        }
        int maxArea =  Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int length = nse[i]-pse[i]-1;
            int width = heights[i];
            int currArea = length*width;
            maxArea = Math.max(currArea,maxArea);
        }
        return maxArea;
    }
}