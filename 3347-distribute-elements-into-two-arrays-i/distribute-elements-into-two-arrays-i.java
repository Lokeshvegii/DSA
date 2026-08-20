class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] a1 = new int[n];
        int[] a2 = new int[n];

        a1[0] = nums[0];
        a2[0] = nums[1];
        int j = 1, k = 1;
        for(int i = 2; i < n; i++) {
    
            if (a1[j - 1] > a2[k - 1]) {
                a1[j] = nums[i];
                j++;
            } else {
                a2[k] = nums[i];
                k++;
            }
        }
            int[] re = new int[n];
            System.arraycopy(a1, 0, re, 0 , j);
            System.arraycopy(a2, 0, re, j, k);
        
        return re;
    }
}