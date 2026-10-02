class Solution {
    public boolean isValid(String s) {
        char[] st = new char[s.length()];
        int top = -1;
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                st[++top] = ch;
            } else {
                if(top == -1) return false;
                char op = st[top--];
                if(ch == ')' && op != '(' ||
                   ch == '}' && op != '{' ||
                   ch == ']' && op != '[') {
                    return false;
                   }
            }
        }
        return top == -1;
    }
}