class Solution {
    public int getSum(int a, int b) {
        if(a==0)return b;
        if(b==0)return a;
        int sumWithoutCarry = a^b;
        int carry = a&b;
        return getSum(sumWithoutCarry,carry<<1);
    }
}