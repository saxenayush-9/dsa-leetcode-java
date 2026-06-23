class Solution {
    public boolean isAnagram(String s, String t) {
        int n  = s.length();
        int m = t.length();
        if(n!=m)return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i=0;i<n;i++){
            int index1 = s.charAt(i)-'a';
            int index2 = t.charAt(i)-'a';
            freq1[index1]++;
            freq2[index2]++;
        }
        for(int j=0;j<26;j++){
            if(freq1[j]!=freq2[j]){
                return false;
            }
        }
        return true;
    }
}