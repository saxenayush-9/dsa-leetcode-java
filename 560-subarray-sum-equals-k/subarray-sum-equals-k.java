class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        int preSum=0;
        int count=0;
        hmap.put(0,1);
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            int key = preSum-k;
            if(hmap.containsKey(key)){
                count+=hmap.get(key);
            }
            if(hmap.containsKey(preSum)){
                hmap.put(preSum,hmap.get(preSum)+1);
            }
            else{
                hmap.put(preSum,1);
            }
        }
        return count;
    }
}