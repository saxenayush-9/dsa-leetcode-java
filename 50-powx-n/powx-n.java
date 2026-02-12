class Solution {
    public double myPow(double x, int n) {
        if(n==0)return 1;
        if(n==1)return x;
        long pow = n;
        if(pow<0){
            pow*=-1;
        }
        double res = calPow(x,pow);
        return n<0?1/res:res;
    }
    public double calPow(double x, long n){
        if(n==0)return 1;
        if(n==1)return x;
        double halfPow = calPow(x,n/2);
        if((n&1)==1){
            return x*halfPow*halfPow;
        }
        else{
            return halfPow*halfPow;
        }
    }
}