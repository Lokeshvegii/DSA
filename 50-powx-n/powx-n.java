class Solution {
    public double myPow(double x, int n) {
        long m = n;
        long exp = Math.abs(m);

        double sol = 1.0;
        while(exp > 0) {
            if((exp & 1) == 1) {
                sol *= x;
            }
            x *= x;
            exp >>= 1;
        }
        return m < 0 ? 1.0 / sol : sol;
    }
}