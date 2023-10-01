public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int totalProfit = 0;

        int n = prices.length;
        int i = 1;
        while(i < n) {
            while(i < n && prices[i] <= prices[i-1]) {
                min = prices[i];
                i++;
            }

            if(i == n) break;
            while(i < n && prices[i] > prices[i-1]) {
                max = prices[i];
                i++;
            }
            totalProfit += max - min;
        }

        if(totalProfit < 0) return 0;
        else return totalProfit;
    }
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock2().maxProfit(new int[] {3,3}));
    }
}
