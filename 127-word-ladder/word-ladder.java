class WordLength{
    String word;
    int sequenceLength;
    WordLength(String word,int sequenceLength){
        this.word = word;
        this.sequenceLength = sequenceLength;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hset= new HashSet<>();
        for(String s:wordList){
            hset.add(s);
        }
        Queue<WordLength> que = new LinkedList<>();
        que.add(new WordLength(beginWord,1));
        
        while(!que.isEmpty()){
            WordLength wordLength = que.remove();
            String word = wordLength.word;
            int length = wordLength.sequenceLength;
            for(int i=0;i<word.length();i++){
                String newString="";
                for(char ch = 'a';ch<='z';ch++){
                    if(ch==word.charAt(i))continue;
                    newString = word.substring(0,i)+ch+word.substring(i+1,word.length());
                    if(hset.contains(newString)){
                        if(newString.equals(endWord)){
                            return length+1;
                        }
                        que.add(new WordLength(newString,length+1));
                        hset.remove(newString);
                    }
                }
            }
        }
        return 0;
    }
}