class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] setRow = new int[n];
        int[] setCol = new int[m];
        for(int i=0;i<n;i++){
            setRow[i]=-1;
        }
        for(int i=0;i<m;i++){
            setCol[i]=-1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    setRow[i]=0;
                    setCol[j]=0;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(setRow[i]==0){
                for(int j=0;j<m;j++){
                    matrix[i][j]=0;
                }    
            }
        }
        for(int i=0;i<m;i++){
            if(setCol[i]==0){
                for(int j=0;j<n;j++){
                    matrix[j][i]=0;
                }    
            }
        }
    }
}