class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int L = logs.length;
        int Q = queries.length;

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[][] arr = new int[Q][2];

        for (int i = 0; i < Q; i++) {
            arr[i][0] = queries[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[Q];

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        for (int i = 0; i < Q; i++) {

            int time = arr[i][0];
            int start = time - x;

            while (right < L && logs[right][1] <= time) {
                int id = logs[right][0];
                map.put(id, map.getOrDefault(id, 0) + 1);
                right++;
            }

            while (left < right && logs[left][1] < start) {
                int id = logs[left][0];
                map.put(id, map.get(id) - 1);

                if (map.get(id) == 0) {
                    map.remove(id);
                }

                left++;
            }

            ans[arr[i][1]] = n - map.size();
        }

        return ans;
    }
}