class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        long left = 1;
        long minCoin = Integer.MAX_VALUE;
        for (int c : coins) minCoin = Math.min(minCoin, c);
        long right = minCoin * (long) k;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (count(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long count(long limit, int[] coins) {
        int n = coins.length;
        long ans = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
                    if (lcm > limit) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) continue;

            long cnt = limit / lcm;

            if ((Integer.bitCount(mask) & 1) == 1) {
                ans += cnt;
            } else {
                ans -= cnt;
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}