class Solution {
    public int mySqrt(int x) {
        if(x<2)return x;
        long low = 1,high=x/2;
        int res = -1;
        while(low<=high){
            long mid=low+((high-low)/2);
            if((mid*mid)<x){
                res=(int)mid;
                low=mid+1;
            }
            else if((mid*mid)>x){
                high=mid-1;
            }
            else{
                return (int)mid;
            }
        }
        return res;
    }
}