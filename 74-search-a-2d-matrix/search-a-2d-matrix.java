class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n-1;
        int searchRow = 0;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(matrix[mid][m-1]>target){
                searchRow = mid;
                high = mid-1;
            }
            else if(matrix[mid][m-1]<target){
                low=mid+1;
            }
            else{
                return true;
            }
        }
        low = 0;high = m-1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(matrix[searchRow][mid]>target){
                high = mid-1;
            }
            else if(matrix[searchRow][mid]<target){
                low = mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}