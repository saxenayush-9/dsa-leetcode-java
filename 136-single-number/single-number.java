class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (Integer i : nums) {
            xor ^= i;
        }
        return xor;
    }
}