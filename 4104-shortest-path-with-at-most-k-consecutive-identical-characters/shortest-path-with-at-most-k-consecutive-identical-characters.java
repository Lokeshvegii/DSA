
import java.util.*;

class Solution {

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj[u].add(new int[]{v, w});
        }

        long INF = Long.MAX_VALUE / 2;

        long[][] dist = new long[n][k + 1];

        for (long[] row : dist) {
            Arrays.fill(row, INF);
        }

        // {distance, node, consecutive count}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            Comparator.comparingLong(a -> a[0])
        );

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long d = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];

            if (d != dist[u][count]) {
                continue;
            }

            if (u == n - 1) {
                return (int) d;
            }

            for (int[] edge : adj[u]) {

                int v = edge[0];
                int w = edge[1];

                int newCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                if (newCount > k) {
                    continue;
                }

                long newDist = d + w;

                if (newDist < dist[v][newCount]) {

                    dist[v][newCount] = newDist;

                    pq.offer(new long[]{
                        newDist, v, newCount
                    });
                }
            }
        }

        return -1;
    }
}
