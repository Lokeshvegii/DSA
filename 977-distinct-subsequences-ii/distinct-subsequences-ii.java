class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1_000_000_007L;

        long[] dp = new long[26];
        long total = 0;

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';

            long old = dp[c];

            dp[c] = (total + 1) % MOD;

            total = (total - old + dp[c] + MOD) % MOD;
        }

        return (int) total;
    }
}