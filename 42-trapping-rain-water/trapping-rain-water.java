class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        if(n<3)return 0;
        int res=0;
        prefix[0]=0;
        postfix[n-1]=0;
        prefix[1]=height[0];
        postfix[n-2]=height[n-1];
        for(int i=2;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],height[i-1]);
        }
        for(int j=n-3;j>=0;j--){
            postfix[j]=Math.max(height[j+1],postfix[j+1]);
        }
        for(int i=1;i<n-1;i++){
            int currHolding = Math.min(prefix[i],postfix[i])-height[i];
            if(currHolding>0){
                res+=currHolding;
            }
        }
        return res;
    }
}