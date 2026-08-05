class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean isValid(char[][] board, int row, int col, char k){
        for(int i=0;i<9;i++){
            if(board[row][i]==k)return false;
            if(board[i][col]==k)return false;
        }
        int boxRow = 3 * (row / 3);
        int boxCol = 3 * (col / 3);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[boxRow + r][boxCol + c] == k) return false;
            }
        }
        return true;
    }
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isValid(board,i,j,k)){
                            board[i][j]=k;
                            if(solve(board))return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}