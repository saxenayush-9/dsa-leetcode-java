class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0]=nums[0];

        int[] postfix = new int[n];
        postfix[n-1]=nums[n-1];

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]*nums[i];
        }

        for(int j=n-2;j>=0;j--){
            postfix[j]=postfix[j+1]*nums[j];
        }

        int[] result = new int[n];

        result[0]=postfix[1];
        result[n-1]=prefix[n-2];

        for(int k=1;k<n-1;k++){
            result[k]=prefix[k-1]*postfix[k+1];
        }
        
        return result;
    }
}