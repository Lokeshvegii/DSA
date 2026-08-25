class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> se = new HashSet<>();
        for (int n : nums) se.add(n);
        int mul = k;
        while(se.contains(mul))  mul  += k;
        return mul;
    }
}