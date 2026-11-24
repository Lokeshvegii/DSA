class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][][] dp = new int[n + 1][2][3];
        // for(int i = n - 1; i >= 0; i--) {
        //     for(int b = 0; b <= 1; b++) {
        //         for(int c = 1; c <= 2; c++) {
        //             if(b == 1) { 
        //                 dp[i][b][c] = Math.max(dp[i + 1][0][c] - prices[i], dp[i + 1][1][c]);
        //             } else {
        //                 dp[i][b][c] = dp[i][b][c] = Math.max(dp[i + 1][1][c - 1] + prices[i], dp[i + 1][0][c]);
        //              }
        //         }
        //     }
        // }
        // return dp[0][1][2];
        int b1 = Integer.MIN_VALUE;
        int b2 = Integer.MIN_VALUE;
        int s1 = 0;
        int s2 = 0;
        for(int c : prices) {
            b1 = Math.max(b1, - c);
            s1 = Math.max(s1, b1 + c);
            b2 = Math.max(b2, s1 - c);
            s2 = Math.max(s2, b2 + c);
        }
        return s2;
    }
}