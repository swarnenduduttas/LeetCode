class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfs(board, n, m, 0, j);
            }
            if (board[n - 1][j] == 'O') {
                dfs(board, n, m, n - 1, j);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(board, n, m, i, 0);
            }
            if (board[i][m - 1] == 'O') {
                dfs(board, n, m, i, m - 1);
            }
        }
        for (int p = 0; p < n; p++) {
            for (int q = 0; q < m; q++) {
                if (board[p][q] == '#') {
                    board[p][q] = 'O';
                } else {
                    board[p][q] = 'X';
                }
            }
        }
    }

    private boolean isValidPos(int n, int m, int row, int col) {
        if (row >= n || row < 0) {
            return false;
        } else
            return col < m && col >= 0;
    }

    private void dfs(char[][] board, int n, int m, int i, int j) {
        int[] dX = { -1, 1, 0, 0 };
        int[] dY = { 0, 0, -1, 1 };
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int row = i + dX[k];
            int col = j + dY[k];
            if (row >= 0 && row < n && col >= 0 && col < m && board[row][col] == 'O') {
                dfs(board, n, m, row, col);
            }
        }
    }
}