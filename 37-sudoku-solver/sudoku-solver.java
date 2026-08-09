class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean valid(char[][] board, int row, int col, char ch){
        for(int i=0;i<9;i++){
            if(board[row][i]==ch)return false;
            if(board[i][col]==ch)return false;
        }

        int startRow = 3*(row/3);
        int startCol = 3*(col/3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[startRow+i][startCol+j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch=='.'){
                    for(char k='1';k<='9';k++){
                        if(!valid(board,i,j,k)){
                            continue;
                        }
                        board[i][j]=k;
                        if(solve(board))return true;
                        board[i][j]='.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
}