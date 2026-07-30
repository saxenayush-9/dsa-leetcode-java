class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        this.list=list;
        findAllCombination(candidates,0,target,new ArrayList<>());
        return list;
    }
    public void findAllCombination(int[] candidates, int start, int target, List<Integer> li){
        if(target<0)return;
        if(start==candidates.length){
            if(target==0){
                list.add(new ArrayList<>(li));
            }
            return;
        }
        li.add(candidates[start]);
        findAllCombination(candidates, start, target-candidates[start],li);
        li.remove(li.size()-1);
        findAllCombination(candidates, start+1, target,li);
    }
}