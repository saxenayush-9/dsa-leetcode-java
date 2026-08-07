class Solution {
    HashSet<String> dict;
    List<String> list;
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        this.list=list;
        HashSet<String> dict = new HashSet<>();
        for(String str: wordDict){
            dict.add(str);
        }
        this.dict=dict;
        solve(s,0,new ArrayList<>());
        return list;
    }

    public void solve(String s, int start, List<String> li){
        if(start==s.length()){
            StringBuilder sbr = new StringBuilder();
            for(String str: li){
                sbr.append(str+" ");
            }
            if(sbr.length()>0)sbr.deleteCharAt(sbr.length()-1);
            list.add(sbr.toString());
            return;
        }

        for(int i=start;i<s.length();i++){
            String str = s.substring(start,i+1);
            if(!dict.contains(str))continue;
            li.add(str);
            solve(s,i+1,li);
            li.remove(li.size()-1);
        }
    }
}