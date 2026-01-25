class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        if((n1+n2)!=n3)return false;
        int[][] dp=new int[n1][n2];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                dp[i][j]=-1;
            }
        }
        return solve(s1,s2,s3,0,0,dp);
    }
    public boolean solve(String s1, String s2, String s3, int i, int j,int[][] dp){
        if(i<s1.length() && j<s2.length() && dp[i][j]!=-1){
            return dp[i][j]==1?true:false;
        }
        if (i == s1.length() && j == s2.length()) return true;
        if(i>=s1.length() && j>=s2.length())return false;
        boolean ans = false;
        if(i<s1.length() && (s1.charAt(i)==s3.charAt(i+j))){
            ans|= solve(s1,s2,s3,i+1,j,dp);
        }
        if(j<s2.length() && (s2.charAt(j)==s3.charAt(i+j))){
            ans|= solve(s1,s2,s3,i,j+1,dp);
        }
        if(i<s1.length() && j<s2.length()){
            dp[i][j]=ans?1:0;
        }
        return ans;
    }
}