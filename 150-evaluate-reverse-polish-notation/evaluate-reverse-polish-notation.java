class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if(n==1)return Integer.parseInt(tokens[0]);
        Stack<Integer> stk =new Stack<>();
        for(int i=0;i<n;i++){
            String operation = tokens[i];
            if(!"+-/*".contains(operation)){
                stk.push(Integer.parseInt(operation));
                continue;
            }
            int b = stk.pop();
            int a = stk.pop();
            switch(operation){
                case "*" :{
                    stk.push(a*b);
                    break;
                }
                case "/" :{
                    stk.push(a/b);
                    break;
                }
                case "+" :{
                    stk.push(a+b);
                    break;
                }
                case "-" :{
                    stk.push(a-b);
                    break;
                }
                default :{
                    break;
                }
            }
        }
        return stk.peek();
    }
}