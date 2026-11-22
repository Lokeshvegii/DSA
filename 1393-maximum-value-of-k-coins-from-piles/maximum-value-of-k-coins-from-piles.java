class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] dp = new int[k + 1];
        for(List<Integer> pile : piles) {
            int m = pile.size();
            int[] prefix = new int[m + 1];
            for(int i = 1; i <= m; i++) {
                prefix[i] = prefix[i - 1] + pile.get(i - 1);
            }
            for(int i = k; i >= 1; i--) {
                for(int j = 1; j <= Math.min(i, m); j++) {
                    dp[i] = Math.max(dp[i], dp[i - j] + prefix[j]);
                }
            }
        }
        return dp[k];
    }
}