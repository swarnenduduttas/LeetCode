class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = calculateRowOfMaxElement(mat, n, mid);
            int element = mat[row][mid];
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < m ? mat[row][mid + 1] : -1;

            if (element > left && element > right)
                return new int[]{row, mid};
            else if (element < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

     private int calculateRowOfMaxElement(int[][] mat, int n, int col) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if(mat[i][col] > max){
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}