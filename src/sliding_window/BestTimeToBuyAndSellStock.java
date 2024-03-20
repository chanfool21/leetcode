package sliding_window;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;

        if(prices.length < 2) return 0;

        int maxProfit = 0;
        while(sell < prices.length) {
            if(prices[sell] > prices[buy]) {
                maxProfit = Math.max(maxProfit, (prices[sell] - prices[buy]));
            } else {
                buy = sell;
            }

            sell++;
        }

        return maxProfit;
    }
}
