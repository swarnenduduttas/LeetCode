class Solution {
    public int swimInWater(int[][] heights) {

        int n = heights.length, m = heights[0].length;
        int[][] distArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distArray[i], Integer.MAX_VALUE);
        }
        distArray[0][0] = heights[0][0];

        PriorityQueue<WeightPair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new WeightPair(heights[0][0], new Pair(0, 0)));
        while (!pq.isEmpty()) {
            int[] dX = { 1, -1, 0, 0 };
            int[] dY = { 0, 0, -1, 1 };
            var weightPair = pq.poll();
            int distSoFar = weightPair.weight;
            int row = weightPair.pair.row;
            int col = weightPair.pair.col;
            for (int i = 0; i < 4; i++) {
                int r = row + dY[i];
                int c = col + dX[i];
                if (c >= 0 && c < m && r >= 0 && r < n) {
                    int dist = Math.abs(heights[row][col] - heights[r][c]);
                    int newDist = Math.max(distSoFar, heights[r][c]);
                    if (newDist < distArray[r][c]) {
                        distArray[r][c] = newDist;
                        pq.add(new WeightPair(newDist, new Pair(r, c)));
                    }
                }
            }
        }
        return distArray[n - 1][m - 1];
    }
}

class WeightPair {
    int weight;
    Pair pair;

    public WeightPair(int weight, Pair pair) {
        this.weight = weight;
        this.pair = pair;
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