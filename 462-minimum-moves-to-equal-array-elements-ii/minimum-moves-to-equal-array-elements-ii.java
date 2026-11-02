class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = nums[n / 2] ;
        int sum = 0;
        for(int num : nums) {
            sum += Math.abs(num - mid);
        }
        return sum;
    }
}