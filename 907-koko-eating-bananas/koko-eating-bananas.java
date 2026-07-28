class Solution {
    public boolean canEat(int[] arr, int num, int h){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=num){
                count++;
            }
            else{
                count+=arr[i]/num;
                if(arr[i]%num!=0){
                    count++;
                }
            }
            if(count>h)return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int minEatingSpeed = 1;
        if(h<n)return -1;
        int max = Integer.MIN_VALUE;
        for(Integer i : piles){
            max = Math.max(max,i);
        }
        int low = 1, high = max;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(canEat(piles,mid,h)){
                minEatingSpeed = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return minEatingSpeed;
    }
}