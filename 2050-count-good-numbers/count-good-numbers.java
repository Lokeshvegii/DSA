class Solution {
    static final long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long e =  n / 2;
        long o = (n + 1) / 2;
        long f = power(4, e);
        long s = power(5, o);
        return (int) ((f * s) % MOD);
    }
    public long power(long base, long exp) {
        long re = 1;
        while(exp > 0) {
            if((exp & 1) == 1) {
                    re = (re * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return re;
    }
}