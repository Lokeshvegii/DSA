class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        boolean flag = false;

        for(int x : nums) {
            xor ^= x;
            if(x != 0) {
                flag = true;
            }
        }

        if(xor != 0) {
            return n;
        }
        
        return flag ? nums.length - 1 : 0;
    }
}