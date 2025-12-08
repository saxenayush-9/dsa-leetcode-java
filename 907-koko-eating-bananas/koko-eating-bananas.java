class Solution {
    public long timeToEat(int[] piles,int n, int h){
        long totalTime = 0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]<=n){
                totalTime++;
            }
            else{
                if(piles[i]%n==0){
                    totalTime+=piles[i]/n;
                }
                else{
                    totalTime+=piles[i]/n;
                    totalTime++;
                }
            }
        }
        return totalTime;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for (Integer i : piles) {
            max = Math.max(max, i);
        }
        int low = 1, high = max;
        int num = piles.length;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (timeToEat(piles, mid, h) > h) {
                low = mid + 1;
            } else {
                num = mid;
                high = mid - 1;
            }
        }
        return num;
    }
}