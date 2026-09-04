class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] sm = new int[n];

        sm[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            sm[i] = Math.min(nums[i], sm[i + 1]);
        }
        int lm = 0;
        for(int i = 0; i < n; i++) {
            lm = Math.max(lm, nums[i]);
            int s = lm - sm[i];
            if(s <= k) {
                return i;
        }
    }
    return -1;
    }
}