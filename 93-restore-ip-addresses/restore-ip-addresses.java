class Solution {
    List<String> list;
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        this.list=list;
        traverse(s,0,new ArrayList());
        return list;
    }
    public boolean validInteger(String str){
        if(str.length()>1 && str.charAt(0)=='0')return false;
        if(str.length()>3 || str.length()<1)return false;
        int n = Integer.parseInt(str.trim());
        if(0<=n && n<=255)return true;
        return false;
    }
    public void traverse(String s, int start, List<String> li){
        if(start==s.length()){
            if(li.size()==4){
                StringBuilder sb = new StringBuilder();
                for(String str : li){
                    sb.append(str+'.');
                }
                sb.deleteCharAt(sb.length()-1);
                list.add(sb.toString());
            }
            return;
        }
        for(int i=start;i<s.length();i++){
            String str = s.substring(start,i+1);
            if(!validInteger(str))continue;
            li.add(str);
            traverse(s,i+1,li);
            li.remove(li.size()-1);
        }
    }
}