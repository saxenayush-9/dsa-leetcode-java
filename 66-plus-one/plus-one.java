class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1]<9){
            digits[n-1]++;
            return digits;
        }
        int carry=1;
        for(int i=n-1;i>=0;i--){
            int sum = digits[i]+carry;
            digits[i]=sum%10;
            carry=sum/10;
        }
        if(carry==0)return digits;
        int[] arr = new int[n+1];
        arr[0]=carry;
        for(int i=0;i<n;i++){
            arr[i+1]=digits[i];
        }
        return arr;
    }
}