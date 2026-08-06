class Solution {
    Set<String> list;
    public List<String> removeInvalidParentheses(String s) {
        Set<String> list = new HashSet<>();
        this.list=list;

        int leftQuota=0,rightQuota=0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch=='('){
                leftQuota++;
            }
            else if(ch==')'){
                if(leftQuota>0){
                    leftQuota--;
                }
                else{
                    rightQuota++;
                }
            }
        }

        solve(s,0,new StringBuilder(),0,0,leftQuota,rightQuota);

        return new ArrayList<>(list);
    }

    public void solve(String s, int start, StringBuilder sb, int currCountLeft, int currCountRight, int leftQuota, int rightQuota){
        if(start==s.length()){
            if(currCountLeft==currCountRight && leftQuota==0 && rightQuota==0){
                list.add(sb.toString());
            }
            return;
        }

        char ch = s.charAt(start);
        

        //pick the character
        if(ch=='('){
            currCountLeft++;
            sb.append(ch);
            solve(s,start+1,sb,currCountLeft,currCountRight,leftQuota,rightQuota);
            currCountLeft--;
            sb.deleteCharAt(sb.length()-1);
        }
        else if(ch==')'){
            if(currCountLeft>currCountRight){
                currCountRight++;
                sb.append(ch);
                solve(s,start+1,sb,currCountLeft,currCountRight,leftQuota,rightQuota);
                currCountRight--;
                sb.deleteCharAt(sb.length()-1);
            }
        }
        else{
            sb.append(ch);
            solve(s,start+1,sb,currCountLeft,currCountRight,leftQuota,rightQuota);
            sb.deleteCharAt(sb.length()-1);
        }

        //not pick the character
        if(ch=='(' && leftQuota>0){
            solve(s,start+1,sb,currCountLeft,currCountRight,leftQuota-1,rightQuota);
        }
        else if(ch==')' && rightQuota>0){
            solve(s,start+1,sb,currCountLeft,currCountRight,leftQuota,rightQuota-1);
        }
    }
}