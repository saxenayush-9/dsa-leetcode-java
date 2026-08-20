class Solution {
    class Node{
        int row;
        int col;
        int distance;
        Node(int row, int col, int distance){
            this.row=row;
            this.col=col;
            this.distance=distance;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<Node> que = new LinkedList<>();
        if(grid[0][0]==1)return -1;
        que.add(new Node(0,0,1));
        grid[0][0]=1;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        while(!que.isEmpty()){
            Node node = que.remove();

            int row = node.row;
            int col = node.col;
            int distance = node.distance;
            
            if(row==n-1 && col==n-1) return distance;


            for(int[] dir: dirs){
                int currRow = row+dir[0];
                int currCol = col+dir[1];

                if(currRow>=0 && currCol>=0 && currRow<n && currCol<n && grid[currRow][currCol]==0){
                    que.add(new Node(currRow,currCol,distance+1));
                    grid[currRow][currCol]=1;
                }
            }
        }
        return -1;
    }
}