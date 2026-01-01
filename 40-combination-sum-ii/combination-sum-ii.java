class Solution {
    List<List<Integer>> list;
    int[] nums;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        this.list=list;
        this.nums=candidates;
        List<Integer> li = new ArrayList<>();
        solve(li,0,target);
        return list;
    }
    public void solve(List<Integer> li, int start, int target){
        if(start==nums.length){
            if(target==0){
                list.add(new ArrayList<>(li));
            }
            return;
        }
        if(target<0)return;
        li.add(nums[start]);
        solve(li,start+1,target-nums[start]);
        li.remove(li.size()-1);
        int index = start+1;
        while(index<nums.length && nums[index]==nums[index-1]){
            index++;
        }
        solve(li,index,target);
    }
}