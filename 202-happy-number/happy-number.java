class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hset = new HashSet<>();
        while(n>1){
            if(!hset.contains(n)){
                hset.add(n);
            }
            else{
                return false;
            }
            int num = n;
            int sum = 0;
            while(num>0){
                int lastDigit = num%10;
                sum+=lastDigit*lastDigit;
                num=num/10;
            }
            n=sum;
        }
        return true;
    }
}