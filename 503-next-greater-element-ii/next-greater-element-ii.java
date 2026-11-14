class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] re = new int[n];
        Arrays.fill(re, -1);
        for(int i = 2 * n - 1; i >= 0; i --) {
            int id = i % n;
            while(!st.isEmpty() && st.peek() <= nums[id]) {
                st.pop();
            }
            if(i < n) {
                if(!st.isEmpty()) re[id] = st.peek();
            }
            st.push(nums[id]);
        }
        return re;
    }
}