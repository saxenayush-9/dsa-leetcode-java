class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            freq[index]++;
        }
        int k = s1.length();
        int[] subfreq = new int[26];
        for (int i = 0; i < k; i++) {
            int index = s2.charAt(i) - 'a';
            subfreq[index]++;
        }
        int count = 0;
        for (int j = 0; j < 26; j++) {
            if (freq[j] != subfreq[j]) {
                count++;
            }
        }
        if (count == 0) return true;
        int i = k;
        while (i < s2.length()) {
            subfreq[s2.charAt(i-k) - 'a']--;
            subfreq[s2.charAt(i) - 'a']++;
            count = 0;
            for (int j = 0; j < 26; j++) {
                if (freq[j] != subfreq[j]) {
                    count++;
                }
            }
            if (count == 0) return true;
            i++;
        }
        return false;
    }
}