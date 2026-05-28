class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0)
            return n;
        int l = 0, r = 0;
        int maxLength = 0;
        int[] position = new int[256];
        Arrays.fill(position, -1);
        while (r < n) {
            int index = s.charAt(r);
            if (position[index] >= l) {
                l = position[index] + 1;
            }
            position[index] = r;
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}