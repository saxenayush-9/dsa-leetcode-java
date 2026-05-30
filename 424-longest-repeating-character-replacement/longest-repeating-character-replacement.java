class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l=0,r=0;
        int[] freq = new int[26];
        int maxFreq = Integer.MIN_VALUE;
        int maxLength = 0;
        while(r<n){
            int index = s.charAt(r)-'A';
            freq[index]++;
            maxFreq=Math.max(maxFreq,freq[index]);
            int currLength = r-l+1;
            if(currLength-maxFreq>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            maxLength=Math.max(maxLength,r-l+1);
            r++;
        }
        return maxLength;
    }
}