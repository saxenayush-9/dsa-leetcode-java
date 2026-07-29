class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        this.list = list;
        findAllSubsets(nums,0,new ArrayList<>());
        return list;
    }

    public void findAllSubsets(int[] arr, int start,List<Integer> li){
        if(start==arr.length){
            list.add(new ArrayList<>(li));
            return;
        }
        li.add(arr[start]);
        findAllSubsets(arr,start+1,li);
        li.remove(li.size()-1);
        findAllSubsets(arr,start+1,li);
    }
}