class Solution {

    public boolean placingFeasible(int[] position, int balls, int distance){
        int n = position.length;
        balls--;
        int lastPosition = position[0];
        for(int i=1;i<n;i++){
            if(position[i]-lastPosition<distance)continue;
            lastPosition=position[i];
            balls--;
        }
        return balls>0? false:true;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int n = position.length;

        int low = 1;
        int high = position[n-1]-position[0];

        int ans = -1;

        while(low<=high){
            int mid = low+((high-low)/2);
            if(placingFeasible(position,m,mid)){
                ans = mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}