class Solution {
    public int hammingWeight(int n){
        if(n==0)return 0;
        if((n&1)==1){
            return 1+hammingWeight(n>>1);
        }
        else{
            return hammingWeight(n>>1);
        }
    }
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=1;i<=n;i++){
            res[i]=hammingWeight(i);
        }
        return res;
    }
}