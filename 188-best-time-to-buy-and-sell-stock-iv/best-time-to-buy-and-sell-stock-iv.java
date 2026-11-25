class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][ 2 * k + 1];
        for(int i =  n - 1; i >= 0; i--) {
            for(int tr = 2 * k - 1; tr >= 0; tr--) {
                if(tr % 2 == 0) {
                    dp[i][tr] = Math.max(dp[i + 1][tr + 1] - prices[i], dp[i + 1][tr]); 
                } else {
                    dp[i][tr] = Math.max(dp[i + 1][tr + 1] + prices[i], dp[i + 1][tr]);
                }
            }
        }
        return dp[0][0];
    }
}