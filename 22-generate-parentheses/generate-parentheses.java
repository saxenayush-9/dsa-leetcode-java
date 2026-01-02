class Solution {
    List<String> list;
    int countOpen = 0;
    int countClose = 0;
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n==1){
            list.add("()");
            return list;
        }
        this.list=list;
        StringBuilder sb = new StringBuilder();
        solve(sb,2*n);
        return list;
    }
    public void solve(StringBuilder sb, int n){
        if(sb.length()==n){
            list.add(sb.toString());
            return;
        }
        if(countOpen>=countClose && countOpen<n/2){
            sb.append("(");
            countOpen++;
            solve(sb,n);
            countOpen--;
            sb.deleteCharAt(sb.length()-1);
        }
        if(countClose<countOpen && countClose<n/2){
            sb.append(")");
            countClose++;
            solve(sb,n);
            sb.deleteCharAt(sb.length()-1);
            countClose--;
        }
    }
}