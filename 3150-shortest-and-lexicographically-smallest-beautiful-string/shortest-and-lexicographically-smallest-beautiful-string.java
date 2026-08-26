class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int[] ones = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') ones[count++] = i;
        }

        if(count < k) return "";

        String ans = "";
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i + k - 1 < count; i++) {
            int l = ones[i];
            int r = ones[i + k - 1];

            int len = r - l + 1;

            if(len < minLen) {
                minLen = len;
                ans = s.substring(l, r + 1);
            } else if(len == minLen) {
                String c = s.substring(l, r + 1);

                if(c.compareTo(ans) < 0) ans = c;
            }
        }
        return ans;
    }
}