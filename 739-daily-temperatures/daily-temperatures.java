class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && temperatures[stk.peek()]<=temperatures[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                res[i]=0;
            }
            else{
                res[i]=stk.peek()-i;
            }
            stk.push(i);
        }
        return res;
    }
}