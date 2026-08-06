class Solution {
    List<List<String>> list;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        this.list=list;

        List<String> board = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            sb.append('.');
        }

        for(int i=0;i<n;i++){
            board.add(sb.toString());
        }

        HashSet<Integer> visitedCol =  new HashSet<>();
        HashSet<Integer> visitedDiagonal1 = new HashSet<>();
        HashSet<Integer> visitedDiagonal2 = new HashSet<>();

        solve(n,0,board,visitedCol,visitedDiagonal1,visitedDiagonal2);
        return list;
    }

    public boolean isValid(int row,int col, HashSet<Integer> visitedCol, HashSet<Integer> visitedDiagonal1,HashSet<Integer> visitedDiagonal2){
        if(visitedCol.contains(col))return false;
        if(visitedDiagonal1.contains(row-col))return false;
        if(visitedDiagonal2.contains(row+col))return false;
        return true;
    };

    public void solve(int n, int row, List<String> board, HashSet<Integer> visitedCol, HashSet<Integer> visitedDiagonal1, HashSet<Integer> visitedDiagonal2){
        if(row==n){
            list.add(new ArrayList<>(board));
            return;
        }
        for(int col=0;col<n;col++){
            if(!isValid(row,col,visitedCol,visitedDiagonal1,visitedDiagonal2)){
                continue;
            }
            //place the queen
            StringBuilder sbPlace = new StringBuilder(board.get(row));
            sbPlace.setCharAt(col,'Q');
            board.set(row,sbPlace.toString());
            
            visitedCol.add(col);
            visitedDiagonal1.add(row-col);
            visitedDiagonal2.add(row+col);

            solve(n,row+1,board,visitedCol,visitedDiagonal1,visitedDiagonal2);

            //unplace the queen
            StringBuilder sbUnplace = new StringBuilder(board.get(row));
            sbUnplace.setCharAt(col,'.');
            board.set(row,sbUnplace.toString());
            
            visitedCol.remove(col);
            visitedDiagonal1.remove(row-col);
            visitedDiagonal2.remove(row+col);
        }
    }
}