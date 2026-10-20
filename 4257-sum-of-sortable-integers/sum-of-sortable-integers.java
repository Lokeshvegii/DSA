class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];
        int[] suffMin = new int[n + 1];
        int[] prefDrop = new int[n + 1];

        prefMax[0] = Integer.MIN_VALUE;
        suffMin[n] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
            prefDrop[i + 1] = prefDrop[i];
            if (i > 0 && nums[i - 1] > nums[i]) {
                prefDrop[i + 1]++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], nums[i]);
        }

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

            for (int s = 0; s < n; s += k) {
                int e = s + k - 1;

                int descents = prefDrop[e + 1] - prefDrop[s];

                if (nums[e] > nums[s]) {
                    descents++;
                }

                if (descents > 1) {
                    valid = false;
                    break;
                }

                if (s > 0 && prefMax[s] > suffMin[s]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}