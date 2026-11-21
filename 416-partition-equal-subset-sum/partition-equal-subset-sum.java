class Solution {
    public boolean solve(int id, int k, int[] a, Boolean[][] dp) {
        if(k == 0) return true;
        if(id == 0) return(a[0] == k);
        if(dp[id][k] != null) return dp[id][k];
        boolean n = solve(id - 1, k, a, dp);
        boolean  y = false;
        if(a[id] <= k) y = solve(id - 1, k - a[id], a, dp);
        return dp[id][k] = y || n;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        Boolean[][] dp = new Boolean[n][target + 1];
        return solve(n - 1, target, nums, dp);
    }
}