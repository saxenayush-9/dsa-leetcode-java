class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> preFixSumFreq = new HashMap<>();
        
        int n = nums.length;
        int count=0;

        preFixSumFreq.put(0,1);
        int preFixSum=0;
        
        for(int i=0;i<n;i++){
            preFixSum+=nums[i];            
            int requiredPrefix = preFixSum-k;

            if(preFixSumFreq.containsKey(requiredPrefix)){
                int lastCount = preFixSumFreq.get(requiredPrefix);
                count+=lastCount;
            }
            preFixSumFreq.compute(preFixSum, (key, value) -> value == null ? 1 : value + 1);
        }
        return count;
    }
}