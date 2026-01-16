class Solution {
    public boolean isPalindrome(String s, int start, int end){
        int low = start;
        int high = end;
        while(low<=high){
            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int startIndex=0;
        int length=1;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int currLen = 0;
                if(isPalindrome(s,i,j)){
                    currLen = j-i+1;
                }
                if(currLen>length){
                    length=currLen;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex,startIndex+length);
    }
}