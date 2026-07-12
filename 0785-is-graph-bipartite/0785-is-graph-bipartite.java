class Solution {
   boolean result = true;

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == -1) {
                dfs(graph, i, 0, colors);
            }
        }
        return result;
    }

    void dfs(int[][] graph, int node, int c, int[] colors) {
        colors[node] = c;
        for (int i = 0; i < graph[node].length; i++) {
            int neighbour = graph[node][i];
            if (colors[neighbour] != -1 && colors[neighbour] == colors[node]) {
                result = false;
            }
            if (colors[neighbour] == -1) {
                dfs(graph, neighbour, 1 - c, colors);
            }
        }
    }
}