class Solution {
    Set<String> dict;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for(String str: wordDict){
            dict.add(str);
        }
        this.dict=dict;
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return solve(s,0,memo);
    }

    public boolean solve(String s,int start,int[] memo){
        if(start==s.length()){
            return true;
        }
        int currState = memo[start];
        if(currState!=-1){
            if(currState==1)return true;
            return false;
        }

        for(int i=start;i<s.length();i++){
            String str = s.substring(start,i+1);
            if(!dict.contains(str))continue;
            if(solve(s,i+1,memo)){
                memo[start]=1;
                return true;
            }
        }
        memo[start]=0;
        return false;
    }
}