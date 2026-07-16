class Solution {
   public int networkDelayTime(int[][] edges, int V, int k) {
        int ans = -1;
        int[] res = new int[V];
        Arrays.fill(res, Integer.MAX_VALUE);
        List<List<EdgeWeightPair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];
            int w = edge[2];
            adj.get(s - 1).add(new EdgeWeightPair(d - 1, w));
        }

        PriorityQueue<EdgeWeightPair> pq =
                new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new EdgeWeightPair(k-1, 0));
        res[k - 1] = 0;

        while (!pq.isEmpty()) {
            EdgeWeightPair pair = pq.poll();
            int node = pair.edge;
            int weight = pair.weight;
            if (weight > res[node]) {
                continue;
            }
            for (int i = 0; i < adj.get(node).size(); i++) {
                EdgeWeightPair neighbour = adj.get(node).get(i);
                if (res[neighbour.edge] > neighbour.weight + weight) {
                    res[neighbour.edge] = neighbour.weight + weight;
                    pq.add(new EdgeWeightPair(neighbour.edge, weight + neighbour.weight));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < V; i++) {
            max = Math.max(res[i], max);
        }
        return max == Integer.MAX_VALUE ? ans : max;
    }
}

class EdgeWeightPair {
    Integer edge;
    Integer weight;

    public EdgeWeightPair(Integer edge, Integer weight) {
        this.edge = edge;
        this.weight = weight;
    }
}