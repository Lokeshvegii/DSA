
class Solution {
    static final int MOD = 1_000_000_007;
    long[] fact;
    long[] invFact;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        fact = new long[n + 1];
        invFact = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[n] = power(fact[n], MOD - 2);
        for (int i = n; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        return (int) ((solve(nums) - 1 + MOD) % MOD);
    }

    private long solve(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return 1;
        }

        int root = nums[0];
        int[] left = new int[n];
        int[] right = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < root) {
                left[l++] = nums[i];
            } else {
                right[r++] = nums[i];
            }
        }

        long ways = choose(l + r, l);
        ways = ways * solve(java.util.Arrays.copyOf(left, l)) % MOD;
        ways = ways * solve(java.util.Arrays.copyOf(right, r)) % MOD;

        return ways;
    }

    private long choose(int n, int k) {
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    private long power(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return result;
    }
}
