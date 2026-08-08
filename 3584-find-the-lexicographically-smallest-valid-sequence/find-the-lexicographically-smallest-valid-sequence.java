class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[] dp = new int[n + 1];
        int j = m - 1;
        for(int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];
            if(j >= 0 && w1[i] == w2[j]) {
                dp[i]++;
                j--;
            }
        }
        boolean flag = true;
        int[] seq = new int[m];
        int k = 0, l = 0;
        while(k < n && l < m) {
            if(w1[k] == w2[l]) {
                seq[l] = k;
                l++;
            }
            else if(flag == true && dp[k + 1] >= m - l - 1) {
                seq[l] = k;
                l++;
                flag = false;
            }
            k++;
        }
        return l == m ? seq : new int[0];
    }
}