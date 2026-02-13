class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if(num1.equals("0") || num2.equals("0"))return "0";
        int[] ans = new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int currSum = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int numIndex = i+j+1;
                int carryIndex = i+j;
                int sum = ans[numIndex]+currSum;
                ans[numIndex]=sum%10;
                ans[carryIndex]+=sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<ans.length;k++){
            if(ans[k]==0 && sb.length()==0)continue;
            sb.append(ans[k]); 
        }
        return sb.toString();
    }
}