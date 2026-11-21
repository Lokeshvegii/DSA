class Solution {
    // public boolean solve(int id, int k, int[] a, Boolean[][] dp) {
    //     if(k == 0) return true;
    //     if(id == 0) return(a[0] == k);
    //     if(dp[id][k] != null) return dp[id][k];
    //     boolean n = solve(id - 1, k, a, dp);
    //     boolean  y = false;
    //     if(a[id] <= k) y = solve(id - 1, k - a[id], a, dp);
    //     return dp[id][k] = y || n;
    // }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[n][target + 1];

        for(int i = 0; i < n; i ++) {
            dp[i][0] = true;
        }

        if(nums[0] <= target) dp[0][nums[0]] = true;

        for(int i = 1; i < n ; i++) {
            for(int j = 1; j < target + 1; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if(nums[i] <= j) take = dp[i - 1][j - nums[i]];
                dp[i][j] = take || notTake;
            }
        }
        return dp[n - 1][target];
    }
}