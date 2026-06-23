class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String,List<String>> hmap = new HashMap<>();
        for(String str: strs){
            StringBuilder s = new StringBuilder();
            int[] freq = new int[26];

            for(int i=0;i<str.length();i++){
                int index = str.charAt(i)-'a';
                freq[index]++;
            }

            for(int j=0;j<26;j++){
                char ch = (char)('a'+j);
                s.append(ch);
                s.append(freq[j]);
            }

            String key = s.toString();
            System.out.println(key);
            if(!hmap.containsKey(key)){
                List<String> li = new ArrayList<>();
                li.add(str);
                hmap.put(key,li);
            }
            else{
                hmap.get(key).add(str);
            }
        }
        for(String key : hmap.keySet()){
            list.add(hmap.get(key));
        }
        return list;
    }
}