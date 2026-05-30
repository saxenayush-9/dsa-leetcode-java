class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hmap = new HashMap<>();
        for(String str : strs){
            int[] arr = new int[26];
            for(int i=0;i<str.length();i++){
                int index = str.charAt(i)-'a';
                arr[index]++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append(arr[i]+",");
            }
            String key = sb.toString();
            System.out.println(key);
            if(hmap.containsKey(key)){
                hmap.get(key).add(str);
            }
            else{
                List<String> li = new ArrayList<>();
                li.add(str);
                hmap.put(key,li);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(String key : hmap.keySet()){
            list.add(hmap.get(key));
        }
        return list;
    }
} 