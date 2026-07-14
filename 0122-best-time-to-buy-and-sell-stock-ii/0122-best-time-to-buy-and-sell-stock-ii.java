class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int low = prices[0];
        int high = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];

            if (curr < low) {
                low = curr;
                high = curr;
            }
            else if (curr > high) {
                profit = profit + (curr - low);
                low = curr;
                high = curr;
            }
        }
        return profit;
    }
}