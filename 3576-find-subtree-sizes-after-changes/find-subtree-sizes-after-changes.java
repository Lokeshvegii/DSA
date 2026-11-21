class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] ans = new int[n];
        int[] last = new int[26];
        int[] prev = new int[n];

        Arrays.fill(ans, 1);
        Arrays.fill(last, -1);
        Arrays.fill(prev, -1);

        // Iterative DFS: positive = enter, negative = exit
        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 0;

        while (top > 0) {
            int u = stack[--top];

            if (u >= 0) {
                int c = s.charAt(u) - 'a';

                prev[u] = last[c];
                last[c] = u;

                // Exit event
                stack[top++] = ~u;

                // Visit children
                for (int v : tree[u]) {
                    stack[top++] = v;
                }

            } else {
                u = ~u;

                int c = s.charAt(u) - 'a';

                // Restore previous ancestor
                last[c] = prev[u];

                // Find final parent
                int p = (prev[u] != -1)
                        ? prev[u]
                        : parent[u];

                // Add subtree size to final parent
                if (p != -1) {
                    ans[p] += ans[u];
                }
            }
        }

        return ans;
    }
}
