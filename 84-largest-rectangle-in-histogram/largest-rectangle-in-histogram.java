class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        Stack<Integer> rightSmallerStk = new Stack<>();
        Stack<Integer> leftSmallerStk = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!rightSmallerStk.isEmpty() && heights[rightSmallerStk.peek()]>=heights[i]){
                rightSmallerStk.pop();
            }

            if(rightSmallerStk.isEmpty()){
                rightSmaller[i]=n;
            }
            else{
                rightSmaller[i]=rightSmallerStk.peek();
            }

            rightSmallerStk.push(i);
           
        }

        for(int i=0;i<n;i++){
            while(!leftSmallerStk.isEmpty() && heights[leftSmallerStk.peek()]>=heights[i]){
                leftSmallerStk.pop();
            }

            if(leftSmallerStk.isEmpty()){
                leftSmaller[i]=-1;
            }
            else{
                leftSmaller[i]=leftSmallerStk.peek();
            }

            leftSmallerStk.push(i);
        }

        int maxArea = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int left = leftSmaller[i];
            int right = rightSmaller[i];

            int width = right-left-1;
            int height = heights[i];

            int area = width*height;

            maxArea = Math.max(maxArea,area);
        }

        return maxArea;

    }
}