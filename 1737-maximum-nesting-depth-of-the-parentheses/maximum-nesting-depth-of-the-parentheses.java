class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') count--;
            maxi = Math.max(maxi, count);
        }
        return maxi;
    }
}