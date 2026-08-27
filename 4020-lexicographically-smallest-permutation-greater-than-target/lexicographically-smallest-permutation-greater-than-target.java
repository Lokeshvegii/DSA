class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            count[target.charAt(i) - 'a']--;
        }

        for (int i = n - 1; i >= 0; i--) {

            int cur = target.charAt(i) - 'a';
            count[cur]++;

            boolean validPrefix = true;

            for (int j = 0; j < 26; j++) {
                if (count[j] < 0) {
                    validPrefix = false;
                    break;
                }
            }

            if (!validPrefix) {
                continue;
            }

            int bigger = -1;

            for (int c = cur + 1; c < 26; c++) {
                if (count[c] > 0) {
                    bigger = c;
                    break;
                }
            }

            if (bigger == -1) {
                continue;
            }

            StringBuilder ans = new StringBuilder(n);

            ans.append(target, 0, i);

            ans.append((char) ('a' + bigger));
            count[bigger]--;

            for (int c = 0; c < 26; c++) {
                while (count[c] > 0) {
                    ans.append((char) ('a' + c));
                    count[c]--;
                }
            }

            return ans.toString();
        }

        return "";
    }
}
