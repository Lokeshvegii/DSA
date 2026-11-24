class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for(int i = n - 1; i >= 0; i--) {
            for(int b = 0; b <= 1; b++) {
                for(int c = 1; c <= 2; c++) {
                    if(b == 1) { 
                        dp[i][b][c] = Math.max(dp[i + 1][0][c] - prices[i], dp[i + 1][1][c]);
                    } else {
                        dp[i][b][c] = dp[i][b][c] = Math.max(dp[i + 1][1][c - 1] + prices[i], dp[i + 1][0][c]);
                     }
                }
            }
        }
        return dp[0][1][2];
    }
    // private int solve(int i, int b, int c, int[] arr, int n, int[][][] dp) {
    //     if(c == 0 || i == n) return 0;
    //     if(dp[i][b][c] != -1) return dp[i][b][c];
    //     if(b == 1) { dp[i][b][c] = Math.max(solve(i + 1, 0, c, arr, n, dp) - arr[i], solve(i + 1, 1, c, arr, n, dp));
    //     } else {
    //         dp[i][b][c] = Math.max(solve(i + 1, 1, c - 1, arr, n, dp) + arr[i], solve(i + 1, 0, c, arr, n, dp));
    //     }
    //     return dp[i][b][c];
    // }
}