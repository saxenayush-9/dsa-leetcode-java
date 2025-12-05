class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk =new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if("({[".contains(ch+"")){
                stk.push(ch);
            }
            else{
                if(stk.isEmpty())return false;
                char top = stk.peek();
                if(top=='(' && ch ==')'){
                    stk.pop();
                }
                else if(top=='{' && ch == '}'){
                    stk.pop();
                }
                else if(top=='[' && ch == ']'){
                    stk.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(stk.isEmpty())return true;
        return false;
    }
}