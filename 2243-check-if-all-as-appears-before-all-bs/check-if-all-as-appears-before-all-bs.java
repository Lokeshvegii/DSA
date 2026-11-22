class Solution {
    public boolean checkString(String s) {
        int la = -1, fb = s.length();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') la = i;
            if(s.charAt(i) == 'b' && fb == s.length()) fb = i;
        }
        return la < fb;
    }
}