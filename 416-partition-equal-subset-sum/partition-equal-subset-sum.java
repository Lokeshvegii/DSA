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
        boolean prev[] = new boolean[target + 1];
        prev[0] = true;
        if(nums[0] <= target) prev[nums[0]] = true;

        for(int i = 1; i < n ; i++) {
            boolean curr[] = new boolean[target + 1];
            curr[0] = true;
            for(int j = 1; j < target + 1; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if(nums[i] <= j) take = prev[j - nums[i]];
                curr[j] = take || notTake;
            }
            prev = curr;
        }
        return prev[target];
    }
}