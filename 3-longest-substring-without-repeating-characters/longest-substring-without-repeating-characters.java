class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int l = 0, r = 0;
        int maxLen = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (hmap.containsKey(ch)) {
                if (hmap.get(ch) >= l) {
                    l = hmap.get(ch)+1;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            hmap.put(ch, r);
            r++;
        }
        return maxLen;
    }
}