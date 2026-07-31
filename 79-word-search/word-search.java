class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]){
                    continue;
                }
                if(dfs(board,i,j,n,m,visited,word,0)){
                    return true;
                };
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, int n, int m, boolean[][] visited, String word, int index){
        if(index==word.length())return true;
        if(row<0 || col<0)return false;
        if(row>=n || col>=m)return false;
        if(visited[row][col])return false;
        visited[row][col]=true;
        if(board[row][col]!=word.charAt(index)){
            visited[row][col]=false;
            return false;
        }
        if(
            dfs(board,row+1,col,n,m,visited,word,index+1)||
            dfs(board,row-1,col,n,m,visited,word,index+1)||
            dfs(board,row,col+1,n,m,visited,word,index+1)||
            dfs(board,row,col-1,n,m,visited,word,index+1)
        ){
            return true;
        }
        visited[row][col]=false;
        return false;
    }
}