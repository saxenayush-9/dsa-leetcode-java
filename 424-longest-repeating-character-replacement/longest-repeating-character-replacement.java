class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int l = 0, r = 0;
        int maxFreq = 0;
        int maxLen = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            arr[ch - 'A']++;
            maxFreq = Math.max(arr[ch - 'A'], maxFreq);
            int len = r - l + 1;
            if (len - maxFreq > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}