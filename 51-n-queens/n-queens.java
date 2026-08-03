class Solution {
    List<List<String>> list;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        this.list=list;
        List<String> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(".");
            }
            li.add(sb.toString());
        }
        boolean[] visitedCol = new boolean[n];
        HashSet<Integer> diagonal1 = new HashSet<>();
        HashSet<Integer> diagonal2 = new HashSet<>();

        dfs(n, 0, visitedCol, li, diagonal1, diagonal2);
        return list;
    }

    public void dfs(int n, int row, boolean[] visitedCol, List<String> li,  HashSet<Integer> diagonal1,HashSet<Integer> diagonal2){
        if(row==n){
            list.add(new ArrayList<>(li));
            return;
        }
        for(int col=0;col<n;col++){
            if(visitedCol[col] || diagonal1.contains(row-col) || diagonal2.contains(row+col)){
                continue;
            }

            char[] currRow = li.get(row).toCharArray();
            currRow[col]='Q';
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(currRow[i]);
            }
            li.set(row,sb.toString());

            diagonal1.add(row-col);
            diagonal2.add(row+col);
            visitedCol[col]=true;

            dfs(n, row+1, visitedCol, li,  diagonal1, diagonal2);

            currRow = li.get(row).toCharArray();
            currRow[col]= '.';
            sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(currRow[i]);
            }

            diagonal1.remove(row-col);
            diagonal2.remove(row+col);
            visitedCol[col]=false;

            li.set(row,sb.toString());
        }
    }
}