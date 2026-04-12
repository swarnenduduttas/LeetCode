class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length-1;
        int n = matrix[0].length-1;

        int low = matrix[0][0];
        int high = matrix[m][n];
        int res = -1;

        while(low<=high){
            int guess = (low+high)/2;
            int count = findCount(matrix, guess);
            if(count >= k ){
                res = guess;
                high = guess-1;
            } else {
                low = guess+1;
            }
        }

        return res;
    }

    int findCount(int[][] matrix, int guess) {
        int row = matrix.length-1;
        int col = 0;
        int count = 0;

        while(row >= 0 && col < matrix[0].length){
            if(matrix[row][col] > guess) {
                row--;
            } else {
                count+= row+1;
                col++;
            }
        }
        return count;
    }
}