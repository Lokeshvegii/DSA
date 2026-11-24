class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] a : dp) {
            for(int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return solve(0, 1, 2, prices, n, dp);
    }
    private int solve(int i, int b, int c, int[] arr, int n, int[][][] dp) {
        if(c == 0 || i == n) return 0;
        if(dp[i][b][c] != -1) return dp[i][b][c];
        if(b == 1) { dp[i][b][c] = Math.max(solve(i + 1, 0, c, arr, n, dp) - arr[i], solve(i + 1, 1, c, arr, n, dp));
        } else {
            dp[i][b][c] = Math.max(solve(i + 1, 1, c - 1, arr, n, dp) + arr[i], solve(i + 1, 0, c, arr, n, dp));
        }
        return dp[i][b][c];
    }
}