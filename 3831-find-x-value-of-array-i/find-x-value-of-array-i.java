class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        
        for(int num: nums) {
            int mod = num % k;
            long[] nextDp = new long[k];

            nextDp[mod] = 1;

            for(int r = 0; r < k; r++) {
                int newReaminder = (r * mod) % k;
                nextDp[newReaminder] += dp[r]; 
            }

            for(int r = 0; r < k; r++) {
                result[r] += nextDp[r];
            }

            dp = nextDp;
        }

        return result;
    }
}