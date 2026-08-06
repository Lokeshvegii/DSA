class Solution {
    public int smallestNumber(int n, int t) {
        while (digitProduct(n) % t != 0) {
                n++;
            }
            return n;
        }

    private int digitProduct(int num) {
        int product = 1;

        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }

        return product;
    }
}