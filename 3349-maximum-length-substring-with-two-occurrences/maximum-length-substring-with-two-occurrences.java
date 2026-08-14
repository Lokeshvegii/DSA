class Solution {
    public int maximumLengthSubstring(String s) {
        int freq[] = new int[26];
        int maxLen = 0, i = 0;
        for(int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            freq[ch - 'a']++;

            while(freq[ch - 'a'] > 2) {
                char c = s.charAt(i);
                freq[c - 'a']--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}