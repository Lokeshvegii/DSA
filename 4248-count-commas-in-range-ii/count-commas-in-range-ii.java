class Solution {
    public long countCommas(long n) {
        long cnt = 0;
        long s = 1000;
        long cma = 1;
        while(s <= n) {
            long e = s * 1000 - 1;
            if(e > n) e = n;
            cnt += (e - s + 1) * cma;
            s *= 1000;
            cma++;
        }
        return cnt;
    }
}