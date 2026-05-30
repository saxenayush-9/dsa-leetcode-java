class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++){
            char key = s.charAt(i);
            if(!hmap.containsKey(key)){
                hmap.put(key,1);
            }
            else{
                hmap.put(key,hmap.get(key)+1);
            }
        }
        for(int j=0;j<n;j++){
            char key = s.charAt(j);
            if(hmap.get(key)==1){
                return j;
            }
        }
        return -1;
    }
}