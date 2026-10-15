class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int z = 0;
        for(int i = 0; i < n; i++) {
            Set<Integer> se = new HashSet<>();
            for(int j = i; j < n; j++) {
                se.add(nums.get(j));
                int d = se.size();
                z += d * d;
            }
        }
        return z;
    }
}