class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int mini = prices[0];
        int pro = 0;
        for(int i = 1; i < prices.length; i++) {
           pro = prices[i] - mini;
           mini = Math.min(mini, prices[i]);
           res = Math.max(res, pro);
        }
    return res;
    }
}