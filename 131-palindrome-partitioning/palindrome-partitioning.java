class Solution {
    List<List<String>> list;
    public boolean isPalindrome(String str){
        int low=0,high=str.length()-1;
        while(low<=high){
            if(str.charAt(low)!=str.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        this.list = list;
        traverse(s,0,new ArrayList<>());
        return list;
    }

    public void traverse(String s, int start, List<String> li){
        if(start==s.length()){
            list.add(new ArrayList<>(li));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(!isPalindrome(s.substring(start,i+1))){
                continue;
            }
            li.add(s.substring(start,i+1));
            traverse(s,i+1,li);
            li.remove(li.size()-1);
        }
    }
}