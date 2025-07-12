package designgurus.grokking75;

public class BestTimeToBuyAndSell1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int min = (int) (1e9);
        int i = 0;
        int res = (int) (-1e9);
        while(i < n) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
            i++;
        }

        return res;
    }
}
