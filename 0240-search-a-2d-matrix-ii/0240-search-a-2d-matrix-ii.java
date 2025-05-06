class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {
            int val = matrix[row][col];
            if (val == target)
                return true;
            else if (val > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}