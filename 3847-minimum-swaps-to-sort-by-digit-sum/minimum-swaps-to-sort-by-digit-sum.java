class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int sum = 0, x = nums[i];

            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }

            arr[i][0] = nums[i];
            arr[i][1] = sum;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = arr[i][0];
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> {
            int sa = digitSum(nums[a]);
            int sb = digitSum(nums[b]);

            if (sa != sb) {
                return sa - sb;
            }
            return nums[a] - nums[b];
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || indices[i] == i) {
                visited[i] = true;
                continue;
            }

            int j = i;
            int cycle = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = indices[j];
                cycle++;
            }

            swaps += cycle - 1;
        }

        return swaps;
    }

    private int digitSum(int x) {
        int sum = 0;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }
}