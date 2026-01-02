class Solution {
    List<List<String>> list;
    HashSet<Integer> columns = new HashSet<>();
    HashSet<Integer> dig1 = new HashSet<>();
    HashSet<Integer> dig2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        this.list = list;
        List<String> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            li.add(sb.toString());
        }
        solve(0, n, li);
        return list;
    }

    public void solve(int row, int n, List<String> li) {
        if (row == n) {
            list.add(new ArrayList<>(li));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (columns.contains(col))
                continue;
            if (dig1.contains(row - col))
                continue;
            if (dig2.contains(row + col))
                continue;
            columns.add(col);
            dig1.add(row - col);
            dig2.add(row + col);
            StringBuilder s = new StringBuilder(li.get(row));
            s.setCharAt(col, 'Q');
            li.set(row, s.toString());
            solve(row + 1, n, li);

            s = new StringBuilder(li.get(row));
            s.setCharAt(col, '.');
            li.set(row, s.toString());
            columns.remove(col);
            dig1.remove(row - col);
            dig2.remove(row + col);
        }
    }
}