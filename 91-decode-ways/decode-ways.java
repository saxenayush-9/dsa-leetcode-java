class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        dp[0]=1;
        if(s.charAt(0)=='0')return 0;
        dp[1]=1;

        for(int i=2;i<=n;i++){  
            if(s.charAt(i-1)!='0'){
                dp[i]=dp[i-1]; // not pairing
            } 
            if(s.charAt(i-2)!='0'){ // check for valid pair
                String str = s.charAt(i-2)+""+s.charAt(i-1);
                int num = Integer.parseInt(str);
                System.out.println(num);
                if(num<=26){
                    dp[i]+=dp[i-2];
                }
            } 
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}