package SlidingWindow;

public class BuySellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(BuySellStockFunc(prices));
    }

    private static int BuySellStockFunc(int[] prices) {
        int minElement = Integer.MAX_VALUE;
        int maxDifference = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minElement) {
                minElement = prices[i];
            } else {
                int difference = prices[i] -  minElement;
                if (maxDifference < difference) {
                    maxDifference = difference;
                }
            }
        }

        return maxDifference;
    }
}
