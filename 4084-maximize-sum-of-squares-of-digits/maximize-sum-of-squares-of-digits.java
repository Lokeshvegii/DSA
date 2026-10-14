class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num) return "";
        StringBuilder st = new StringBuilder();
        while(sum >= 9) {
            st.append('9');
            sum -= 9;
            num--;
        }
        if(sum > 0) {
            st.append(sum);
            num--;
        }
        while(num-- > 0) {
            st.append('0');
        }
        return st.toString();
    }
}