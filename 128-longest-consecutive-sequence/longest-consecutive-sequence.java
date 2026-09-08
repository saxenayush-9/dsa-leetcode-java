class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0;i<n;i++){
            hset.add(nums[i]);
        }

        int maxLength= 0;

        for(int num : hset){
            int currLength=0;
            if(hset.contains(num-1))continue;
            while(hset.contains(num)){
                currLength++;
                num++;
            }
            maxLength=Math.max(maxLength,currLength);
        }

        return maxLength;
    }
}