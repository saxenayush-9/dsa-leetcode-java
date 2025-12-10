class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m)return false;
        int[] keyArr = new int[256];
        for (int i = 0; i < n; i++) {
            keyArr[s1.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            sb.append(keyArr[i] + "#");
        }

        String key = sb.toString();

        for (int i = 0; i < 256; i++) {
            keyArr[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            keyArr[s2.charAt(i) - 'a']++;
        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            sb1.append(keyArr[i] + "#");
        }
        String key1 = sb1.toString();

        if (key.equals(key1))
            return true;

        for (int i = n; i < m; i++) {
            keyArr[s2.charAt(i - n) - 'a']--;
            keyArr[s2.charAt(i) - 'a']++;
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < 256; j++) {
                sb2.append(keyArr[j] + "#");
            }
            String keyTemp = sb2.toString();
            if (key.equals(keyTemp))
                return true;
        }
        return false;
    }
}