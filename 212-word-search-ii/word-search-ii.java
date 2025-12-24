class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Solution {
    TrieNode root = new TrieNode();

    public void insert(TrieNode root, String word) {
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

    public List<String> findWords(char[][] board, String[] words) {
        for(int i=0;i<words.length;i++){
            insert(root,words[i]);
        }
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        List<String> li = new ArrayList<>();
        solve(board,visited,li,n,m,root);
        return li;
    }

    public void solve(char[][] board, boolean[][] visited,List<String> li, int n, int m, TrieNode node){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(board,visited,li,i,j,n,m,node,new StringBuilder());
            }
        }
    }

    public void dfs(char[][] board, boolean[][] visited, List<String> li, int row, int col, int n, int m, TrieNode node,StringBuilder sb){
        if(row<0 || col<0) return;
        if(row>=n || col>=m) return;
        if(visited[row][col])return;
        
        char ch = board[row][col];
        int index = ch-'a';
        if(node.children[index]==null){
            return;
        }
        visited[row][col]=true;
        node = node.children[index];
        sb.append(ch);
        if(node.isEnd){
            li.add(sb.toString());
            node.isEnd=false;
        }
        dfs(board,visited,li,row+1,col,n,m,node,sb);
        dfs(board,visited,li,row-1,col,n,m,node,sb);
        dfs(board,visited,li,row,col+1,n,m,node,sb);
        dfs(board,visited,li,row,col-1,n,m,node,sb);
        sb.deleteCharAt(sb.length()-1);
        visited[row][col]=false;
    }
}