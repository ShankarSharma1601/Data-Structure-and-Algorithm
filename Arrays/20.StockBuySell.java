// Best Time to Buy and Sell Stock
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxProfit = 0;
        for(int i = 1;i < prices.length;i++){
            int profit = prices[i] - mini;
            maxProfit = Math.max(maxProfit , profit);
            mini = Math.min(mini , prices[i]);
        }
        return maxProfit;
    }
}