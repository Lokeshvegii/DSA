class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int re = 0;
        int num = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }else if(ch == '+') {
                re += sign * num;
                num = 0;
                sign = 1;
            }else if(ch == '-') {
                re += sign * num;
                num = 0;
                sign = -1;
            } else if(ch == '(') {
                st.push(re);
                st.push(sign);
                re = 0;
                sign = 1;
            } else if(ch == ')') {
                re += sign * num;
                num = 0;
                
                re *= st.pop();
                re += st.pop();
            }
        }
        return re + num * sign;
    }
}