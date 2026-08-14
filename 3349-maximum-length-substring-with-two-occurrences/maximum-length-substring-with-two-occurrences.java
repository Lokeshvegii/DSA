class Solution {
    public int maximumLengthSubstring(String s) {
        int count = 0;
        int i = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            while(mp.get(ch) > 2) {
                char left = s.charAt(i);
                mp.put(left, mp.get(left) - 1);
                i++;
            }
            count = Math.max(j - i + 1, count);
        }
        return count;
    }
}