class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> li = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        if(m==1){
            for(int i=0;i<n;i++){
                li.add(matrix[i][0]);
            }
            return li;
        }
        if(n==1){
            for(int i=0;i<m;i++){
                li.add(matrix[0][i]);
            }
            return li;
        }
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = m-1;

        while(top<=bottom && left<=right){
            if(top==bottom && left==right){
                li.add(matrix[top][right]);
                break;
            }
            //single columnn
            if (top < bottom && left == right) { 
                for (int i = top; i <= bottom; i++) { 
                    li.add(matrix[i][left]); 
                } 
                break; 
            } 

            //single row
            if (left < right && top == bottom) { 
                for (int i = left; i <= right; i++) { 
                    li.add(matrix[top][i]); 
                } 
                break; 
            }
            int row = top;
            int col = left;

            while(col<right){
                li.add(matrix[row][col]);
                col++;
            }

            while(row<bottom){
                li.add(matrix[row][col]);
                row++;
            }
            
            while(col>left){
                li.add(matrix[row][col]);
                col--;
            }
            
            while(row>top){
                li.add(matrix[row][col]);
                row--;
            }
            
            top++;
            bottom--;
            left++;
            right--;
        }
        return li;
    }
}