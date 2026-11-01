class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            count += nums[i] - min;
        }
        return count;
    }
}