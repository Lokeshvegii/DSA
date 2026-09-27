class Solution {
    public String reverseParentheses(String s) {
         int n = s.length();
        Stack<Integer> openBracket = new Stack<>();
        int[] door = new int[n];

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                openBracket.push(i);
            } else if (s.charAt(i) == ')') {
                int j = openBracket.pop();
                door[i] = j;
                door[j] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        int direction = 1;
        for (int i = 0; i < n; i += direction) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = door[i];
                direction = -direction;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}