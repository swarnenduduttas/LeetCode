class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(grid, n, m, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int n, int m, int i, int j, boolean[][] visited) {
        int[] y = {-1, 1, 0, 0};
        int[] x = {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int row = i + y[k];
            int col = j + x[k];
            if (isValidPos(n, m, row, col) && grid[row][col] == '1' && !visited[row][col]) {
                visited[row][col] = true;
                dfs(grid, n, m, row, col, visited);
            }
        }
    }

    private boolean isValidPos(int n, int m, int row, int col) {
        if (row >= n || row < 0) {
            return false;
        } else if (col >= m || col < 0) {
            return false;
        }
        return true;
    }
}