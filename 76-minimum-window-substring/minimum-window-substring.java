class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n)
            return "";
        int[] arr = new int[256];
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            arr[ch]++;
        }
        int l = 0, r = 0, count = 0, length = Integer.MAX_VALUE, startIndex = -1;
        while (r < n) {
            char ch = s.charAt(r);
            if (arr[ch] > 0) {
                count++;
            }
            arr[ch]--;
            while (count == m) {
                if (r - l + 1 < length) {
                    startIndex = l;
                    length = r - l + 1;
                }
                l++;
                arr[s.charAt(l - 1)]++;
                if (arr[s.charAt(l - 1)] > 0) {
                    count--;
                }
            }
            r++;
        }
        if (startIndex == -1)
            return "";
        return s.substring(startIndex, startIndex+length);
    }
}