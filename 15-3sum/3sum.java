class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<=n-3;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int a = -nums[i];
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum = nums[j]+nums[k];
                if(sum>a){
                    k--;
                }
                else if(sum<a){
                    j++;
                }
                else{
                    List<Integer> li =new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(nums[k]);
                    list.add(li);
                    j++;
                    k--;
                    while(j<k){
                        if(nums[j]==nums[j-1]){
                            j++;
                        }
                        else break;
                    }
                    while(k>j){
                        if(nums[k]==nums[k+1]){
                            k--;
                        }
                        else break;
                    }
                }
            }
        }
        return list;
    }
}