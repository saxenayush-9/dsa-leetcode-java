class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int n = nums.length;

        hmap.put(0,1);

        int prefixSum = 0;
        int count = 0;

        for(int i=0;i<n;i++){
            prefixSum +=nums[i];
            int key =  ((prefixSum % k) + k) % k;

            if(hmap.containsKey(key)){
                count+=hmap.get(key);
            }
            
            hmap.compute(key,(ky,v)-> v==null? v=1 : v+1);
        }   
        return count;
    }
}