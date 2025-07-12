package Leetcode150.array;

public class StockBuyAndSell2 {
    public int maxProfit(int[] a) {
        int n = a.length;
        int min = 0;
        int high = 0;

        int i = 1;
        int maxProfit = 0;
        //7,1,5,3,6,4
        while(i < n) {
            while(i < n && a[min] >= a[i]) {
                min = i;
                i++;
            }

            while(i < n && a[high] <= a[i]) {
                high = i;
                i++;
            }



            if(high < min) {
                high = min;
            }
            maxProfit += a[high] - a[min];
            min = high;
        }

        if(maxProfit > 0) return maxProfit;
        else return 0;
    }

    public static void main(String[] args) {
        System.out.println(new StockBuyAndSell2().maxProfit(new int[] {2,4,1}));
    }
}
