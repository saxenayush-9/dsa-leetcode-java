class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        this.list=list;
        solve(nums,0);
        return list;
    }
    public void solve(int[] nums, int start){
        if(start==nums.length){
            List<Integer> li = new ArrayList<>();
            for(Integer i : nums){
                li.add(i);
            }
            list.add(li);
            return;
        }

        for(int i=start;i<nums.length;i++){
            int temp = nums[start];
            nums[start]=nums[i];
            nums[i]=temp;
            solve(nums,start+1);
            temp = nums[start];
            nums[start]=nums[i];
            nums[i]=temp;
        }
    }
}