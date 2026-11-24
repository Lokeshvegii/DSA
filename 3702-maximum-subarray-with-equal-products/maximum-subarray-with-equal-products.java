class Solution {
    public long gcd(long a, long b) {
        while(b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int maxLength(int[] nums) {
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            long pro = 1;
            long lcm = 1;
            long gcd = 0;
            for(int j = i; j < nums.length; j++) {
                pro *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = (lcm / gcd(lcm, nums[j])) * nums[j];
                if(pro == gcd * lcm) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}