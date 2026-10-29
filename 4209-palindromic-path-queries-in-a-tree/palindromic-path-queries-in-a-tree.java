import java.util.*;

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges,
                                        String s, String[] queries) {
        int LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] parent = new int[n];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] order = new int[n];
        int[] prefix = new int[n];
        int[][] up = new int[LOG][n];

        // Iterative DFS
        int[] stack = new int[n];
        int top = 0, timer = 0;
        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];

            tin[u] = timer;
            order[timer++] = u;

            prefix[u] = 1 << (s.charAt(u) - 'a');
            if (u != 0) {
                prefix[u] ^= prefix[parent[u]];
            }

            up[0][u] = parent[u];

            for (int v : graph[u]) {
                if (v == parent[u]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        // Binary lifting table
        for (int k = 1; k < LOG; k++) {
            for (int u = 0; u < n; u++) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }
        }

        // Subtree sizes
        int[] size = new int[n];
        Arrays.fill(size, 1);

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            size[parent[u]] += size[u];
        }

        for (int u = 0; u < n; u++) {
            tout[u] = tin[u] + size[u] - 1;
        }

        Fenwick bit = new Fenwick(n);
        int previous = 0;

        for (int i = 0; i < n; i++) {
            int u = order[i];
            bit.add(i + 1, prefix[u] ^ previous);
            previous = prefix[u];
        }

        char[] chars = s.toCharArray();
        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");
            int u = Integer.parseInt(parts[1]);

            if (parts[0].equals("update")) {
                char c = parts[2].charAt(0);

                int delta = (1 << (chars[u] - 'a'))
                          ^ (1 << (c - 'a'));

                if (delta != 0) {
                    bit.add(tin[u] + 1, delta);
                    bit.add(tout[u] + 2, delta);
                    chars[u] = c;
                }
            } else {
                int v = Integer.parseInt(parts[2]);
                int w = lca(u, v, depth, up, LOG);

                int pu = bit.query(tin[u] + 1);
                int pv = bit.query(tin[v] + 1);

                int mask = pu ^ pv ^ (1 << (chars[w] - 'a'));

                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    private int lca(int u, int v, int[] depth,
                    int[][] up, int LOG) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if (((diff >> k) & 1) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }

    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        void add(int i, int value) {
            for (; i <= n + 1; i += i & -i) {
                tree[i] ^= value;
            }
        }

        int query(int i) {
            int result = 0;

            for (; i > 0; i -= i & -i) {
                result ^= tree[i];
            }

            return result;
        }
    }
}