class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int tot = 0;
        for(int num : nums) {
            tot += num;
        }
        int target = tot - x;
        if(target == 0) return n;
        int  l = 0, sum = 0, maxLen = -1;
        for(int r = 0; r < n; r++) {
            sum += nums[r];
            while( l <= r && sum > target) {
                sum -= nums[l];
                l++;
            }
            if(sum == target) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}