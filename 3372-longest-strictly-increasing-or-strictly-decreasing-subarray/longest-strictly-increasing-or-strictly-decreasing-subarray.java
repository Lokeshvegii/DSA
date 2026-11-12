class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int asc = 1, dec = 1, sol = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]) {
                asc += 1;
                dec = 1;
            } else if(nums[i] < nums[i - 1]) {
                dec += 1;
                asc = 1;
            } else {
                asc = 1;
                dec = 1;
            }
            sol = Math.max(sol, Math.max(asc, dec));
        }
        return sol;
    }
}