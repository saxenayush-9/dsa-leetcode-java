class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return solve(root, word, 0);
    }

    public boolean solve(TrieNode node, String word, int index) {
        if (index == word.length()) return node.isEnd;
        char ch = word.charAt(index);
        if (ch == '.') {
            for(int i=0;i<26;i++){
                if(node.children[i]!=null){
                    if(solve(node.children[i],word,index+1)){
                        return true;
                    }
                }
            }
            return false;
        }
        int idx = ch - 'a';
        if (node.children[idx] == null) return false;
        return solve(node.children[idx], word, index + 1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */