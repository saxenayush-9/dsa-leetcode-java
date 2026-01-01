class Solution {
    List<List<Integer>> list;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        this.list=list;
        this.nums=nums;
        List<Integer> li = new ArrayList<>();
        solve(li,0);
        return list;

    }
    public void solve(List<Integer> li, int start){
        if(start==nums.length){
            list.add(new ArrayList<>(li));
            return;
        }
        li.add(nums[start]);
        solve(li,start+1);
        li.remove(li.size()-1);
        int index = start+1;
        while(index<nums.length && nums[index]==nums[index-1]){
            index++;
        }
        solve(li,index);
    }
}