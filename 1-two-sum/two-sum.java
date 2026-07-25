class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++){
            int key = nums[i];
            if(!hmap.containsKey(target-key)){
                hmap.put(key,i);
            }
            else{
                return new int[] {hmap.get(target-key),i};
            }
        }
        return new int[] {-1,-1};
    }
}