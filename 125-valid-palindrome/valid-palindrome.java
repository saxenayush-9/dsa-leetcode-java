class Solution {
    public boolean isAlphanumeric(char c){
        if(('a'<=c && c<='z') || ('A'<=c && c<='Z') || ('0'<=c && c<='9')) return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0 ;
        int h = n-1;
        while(l<=h){
            char low = s.charAt(l);
            char high = s.charAt(h);
            if(!isAlphanumeric(low)){
                l++;
                continue;
            }
            if(!isAlphanumeric(high)){
                h--;
                continue;
            }
            if('A'<=low && low<='Z'){
                low+=32;
            }
            if('A'<=high && high<='Z'){
                high+=32;
            }
            if(low!=high){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}