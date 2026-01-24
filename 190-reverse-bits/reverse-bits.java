class Solution {
    public int reverseBits(int n) {
        int res=0;
        for(int i=31;i>=0;i--){
            int lastBit=0;
            if((n&1)==1){
                lastBit=1<<i;
            }
            res=res|lastBit;
            n=n>>1;
        }
        return res;
    }
}