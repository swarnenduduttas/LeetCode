class Solution {
  public int orangesRotting(int[][] grid) {
        int[] dY = {-1, 1, 0, 0}, dX = {0, 0, 1, -1};
        Queue<Pair> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    Pair p = new Pair(i, j);
                    q.add(p);
                    grid[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty() && fresh > 0) {
            int qSize = q.size();
            time++;
            while (qSize > 0) {
                Pair p = q.poll();
                int r = p.row;
                int c = p.col;
                for (int k = 0; k < 4; k++) {
                    int i = r + dY[k];
                    int j = c + dX[k];
                    if (valid(i, j, n, m) && grid[i][j] == 1) {
                        q.add(new Pair(i, j));
                        grid[i][j] = -1;
                        fresh--;
                    }
                }
                qSize--;
            }
        }
        return fresh > 0 ? -1 : time ;
    }

    boolean valid(int i, int j, int n, int m) {
        if ((i < 0 || i >= n || j < 0 || j >= m)) {
            return false;
        }
        return true;
    }
}

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}