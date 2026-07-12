class Solution {
   public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int i = 0;
        int j = 0;
        while (j < m) {
            if (board[i][j] == 'O') {
                dfs(board, n, m, i, j);
            }
            j++;
        }
        i = n - 1;
        j = 0;
        while (j < m) {
            if (board[i][j] == 'O') {
                dfs(board, n, m, i, j);
            }
            j++;
        }

        j = m - 1;
        i = 0;
        while (i < n) {
            if (board[i][j] == 'O') {
                dfs(board, n, m, i, j);
            }
            i++;
        }

        j = 0;
        i = 0;
        while (i < n) {
            if (board[i][j] == 'O') {
                dfs(board, n, m, i, j);
            }
            i++;
        }
        for (int p = 0; p < n; p++) {
            for (int q = 0; q < m; q++) {
                if(board[p][q] == '#'){
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
        } else return col < m && col >= 0;
    }

    private void dfs(char[][] board, int n, int m, int i, int j) {
        int[] dX = {-1, 1, 0, 0};
        int[] dY = {0, 0, 1, -1};
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int row = i + dX[k];
            int col = j + dY[k];
            if (isValidPos(n, m, row, col) && board[row][col] == 'O') {
                dfs(board, n, m, row, col);
            }
        }
    }
}