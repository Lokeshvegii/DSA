class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        return max * n - sum;
    }
}