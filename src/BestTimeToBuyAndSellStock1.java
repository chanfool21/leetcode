public class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int totalProfit = Integer.MIN_VALUE;
        int n = prices.length;
        int minLeft[] = new int[n];

        int curMinLeft = prices[0];
        minLeft[0] = curMinLeft;

        for(int i = 1; i < n; i++) {
            if(prices[i] < curMinLeft) {
                curMinLeft = prices[i];
            }

            minLeft[i] = curMinLeft;
        }

        int curMaxRight = prices[n-1];
        totalProfit = curMaxRight - minLeft[n-1];

        for(int i = n-2; i >= 0; i--) {
            curMaxRight = Math.max(curMaxRight, prices[i]);
            totalProfit = Math.max(totalProfit, curMaxRight - minLeft[i]);
        }

        if(totalProfit < 0) return 0;
        else return totalProfit;
    }

    public int maxProfit1(int [] prices) {
        int totalProfit = Integer.MIN_VALUE;
        int n = prices.length;

        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(minPrice < prices[i]) {
                totalProfit = Math.max(totalProfit, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock1().maxProfit(new int[] {7,6,4,3,1}));
    }
}
