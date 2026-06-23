class Solution {
    public String reverseWords(String s) {
        String[] st = s.trim().split("\\s");
        StringBuilder sb = new StringBuilder();
        for(int i=st.length-1;i>=0;i--){
            if(st[i].trim().length()==0)continue;
            sb.append(st[i].trim()+" ");
        }
        String str = sb.toString().trim();
        return str;
    }
}