class Solution {
    public void rotate(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        for(int i =0; i< matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                ans[j][matrix.length -1 -i] = matrix[i][j];
            }
        }

        for(int i =0; i< ans.length; i++){
            for(int j = 0; j< ans[0].length; j++){
                matrix[i][j] = ans[i][j];
            }
        }
    }
}