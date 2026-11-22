class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        List<Integer>[] left = new ArrayList[n + 1];
        List<Integer>[] right = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        // Generate subset sums grouped by number of elements
        for (int mask = 0; mask < (1 << n); mask++) {
            int sumL = 0, sumR = 0;
            int count = Integer.bitCount(mask);

            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    sumL += nums[j];
                    sumR += nums[j + n];
                }
            }

            left[count].add(sumL);
            right[count].add(sumR);
        }

        // Sort right-side subset sums
        for (int i = 0; i <= n; i++) {
            Collections.sort(right[i]);
        }

        long total = 0;
        for (int num : nums) {
            total += num;
        }

        long ans = Long.MAX_VALUE;

        // Select k elements from left and n-k from right
        for (int k = 0; k <= n; k++) {
            List<Integer> a = left[k];
            List<Integer> b = right[n - k];

            for (int x : a) {
                // We want x + y as close as possible to total / 2
                long target = total / 2 - x;

                int idx = lowerBound(b, target);

                if (idx < b.size()) {
                    long sum = (long) x + b.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }

                if (idx > 0) {
                    long sum = (long) x + b.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
            }
        }

        return (int) ans;
    }

    private int lowerBound(List<Integer> list, long target) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}