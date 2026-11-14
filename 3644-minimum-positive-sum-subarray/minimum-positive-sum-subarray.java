class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        long[] pre = new long[n + 1];

        for (int i = 0; i < n; i++)
            pre[i + 1] = pre[i] + nums.get(i);

        TreeMap<Long, Integer> map = new TreeMap<>();
        long ans = Long.MAX_VALUE;

        for (int i = l; i <= n; i++) {
            long x = pre[i - l];
            map.put(x, map.getOrDefault(x, 0) + 1);

            int idx = i - r - 1;
            if (idx >= 0) {
                long y = pre[idx];
                if (map.get(y) == 1) map.remove(y);
                else map.put(y, map.get(y) - 1);
            }

            Long key = map.lowerKey(pre[i]);

            if (key != null)
                ans = Math.min(ans, pre[i] - key);
        }

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}