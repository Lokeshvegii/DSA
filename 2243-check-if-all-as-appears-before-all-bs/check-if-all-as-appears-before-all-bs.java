class Solution {
    public boolean checkString(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'b') count = 1;
            if(s.charAt(i) == 'a' && count == 1) return false;
        }
        return true;
    }
}