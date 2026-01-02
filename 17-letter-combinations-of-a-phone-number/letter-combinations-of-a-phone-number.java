class Solution {
    List<String> list;
    String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        this.list=list;
        solve(0,digits,new StringBuilder());
        return list;
    }
    public void solve(int start,String digits,StringBuilder sb){
        if(start==digits.length()){
            list.add(sb.toString());
            return;
        }
        String nums = arr[digits.charAt(start)-'0'];
        for(int i=0;i<nums.length();i++){
            sb.append(nums.charAt(i));
            solve(start+1,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}