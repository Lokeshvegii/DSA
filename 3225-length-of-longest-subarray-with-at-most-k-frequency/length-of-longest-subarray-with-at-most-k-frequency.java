class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int count = 0;
        int i = 0;

        for(int j = 0; j < n; j++) {
             mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while(mp.get(nums[j]) > k) {
                    mp.put(nums[i], mp.get(nums[i]) - 1);
                    i++;
                }

            count = Math.max(count, j - i + 1);
        }
        
        return count;
    }
}