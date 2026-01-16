class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int a = s.charAt(0)-'0';
        if(a==0)return 0;
        if(n==1)return 1;
        int b = s.charAt(1)-'0';
        int num = (a*10)+b;
        dp[0]= 1;
        if(10<=num && num<=26){
            dp[1]++;
        }
        if(b>0){
            dp[1]++;
        }
        for(int i=2;i<n;i++){
            a = s.charAt(i-1)-'0';
            b = s.charAt(i)-'0';
            num = (a*10)+b;
            dp[i]=0;
            if(10<=num && num<=26){
                dp[i]+=dp[i-2];
            }
            if(b>0){
                dp[i]+=dp[i-1];
            }
        }
        return dp[n-1];
    }
}