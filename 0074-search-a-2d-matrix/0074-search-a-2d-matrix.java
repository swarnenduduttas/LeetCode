class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row*col - 1;

        while(high >= low){
            int guess = (low+high)/2;
            int r = guess/col;
            int c = guess%col;
            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c] > target){
                high = guess-1;
            } else {
                low = guess+1;
            }
        }
        return false;       
    }
}