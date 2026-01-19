class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(String str : wordDict){
                if(str.length()>i)continue;
                if(s.substring(i-str.length(),i).equals(str) && dp[i-str.length()]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}