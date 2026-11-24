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
}