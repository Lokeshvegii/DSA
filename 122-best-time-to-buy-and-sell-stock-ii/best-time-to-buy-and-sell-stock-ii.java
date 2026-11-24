class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int profit = 0;
        // for(int i = 1; i < n; i++) {
        //     if(prices[i] > prices[i - 1]) {
        //         profit += prices[i] - prices[i - 1];
        //     }
        // }
        // return profit;
        int[][] dp = new int[n + 1][2];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return solve(0, 1, prices, n, dp);
        for(int i = n - 1; i >= 0; i--) {
            for(int b = 0; b <= 1; b++) {
                if(b == 1) dp[i][b] = Math.max(dp[i + 1][0] - prices[i], dp[i + 1][1]);
                else dp[i][b] = Math.max(dp[i + 1][1] + prices[i], dp[i + 1][0]);
            }
        }
        return dp[0][1];
    }
    private int solve(int id, int buy, int[] a, int n, int[][] dp) {
        if(id == n) return 0;
        if(dp[id][buy] != -1) return dp[id][buy];
        if(buy == 1) {
            dp[id][buy] = Math.max(solve(id + 1, 0, a, n, dp) - a[id], solve(id + 1, 1, a, n, dp));
        } else {
        dp[id][buy] = Math.max(solve(id + 1, 1, a, n, dp) + a[id], solve(id + 1, 0, a, n, dp));
        }
        return dp[id][buy];
    }
}