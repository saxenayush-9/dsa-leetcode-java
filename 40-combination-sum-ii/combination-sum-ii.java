class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        this.list=list;
        Arrays.sort(candidates);
        traverse(candidates,0,target,new ArrayList<>());
        return list;
    }

    public void traverse(int[] candidates, int start, int target, List<Integer> li){
        if(target<0)return;
        if(start==candidates.length){
            if(target==0){
                list.add(new ArrayList<>(li));
            }
            return;
        };
        li.add(candidates[start]);
        traverse(candidates,start+1,target-candidates[start],li);
        li.remove(li.size()-1);
        int index = start+1;
        while(index<candidates.length && candidates[index]==candidates[index-1]){
            index++;
        }
        traverse(candidates,index,target,li);
    }
}