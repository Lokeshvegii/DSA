class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int end  = 0; end  < s.length(); end++) {
            char ch = s.charAt(end);
            if(mp.containsKey(ch) && mp.get(ch) >= start) {
                start = mp.get(ch) + 1;
            }
            mp.put(s.charAt(end), end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}