class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int d = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                if(d > 0) {
                    res.append(ch);
                }
                d++;
            } else {
                d--;
                if(d > 0) {
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }
}