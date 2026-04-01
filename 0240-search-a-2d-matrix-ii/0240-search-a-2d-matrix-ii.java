class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //start with a corner;
        int row = m-1;
        int col = 0;

        while(row> -1 && col < n) {
            int result = matrix[row][col];
            if(result == target){
                return true;
            } else if(result > target){
                row--;
            } else {
                col++;
            }
        }

        return false;

    }
}