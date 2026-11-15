class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] pre = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int k = l; k <= r; k++) {
            for(int i = 0; i + k <= n; i++) {
                int sum = pre[i + k] - pre[i];
                if(sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }
       return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}