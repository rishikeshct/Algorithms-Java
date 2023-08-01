package TwoDp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};

        Map<String, Integer> map = new HashMap<>();
        System.out.println(StockBuyAndSellFunc(prices, true, false, 0, 0, map));


        int[][] memo = new int[prices.length + 1][2];
        for(int[] row : memo) Arrays.fill(row, -1);

        System.out.println(helperMem(prices, 0, 1, memo));

//        System.out.println(map);
    }


    public static int helperMem(int[] prices, int index, int buy, int[][] dp){
        // Base Case
        if(index >= prices.length) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        int totalProfit = 0;
        if(buy == 1){
            int buyKaro = -prices[index] + helperMem(prices, index + 1, 0, dp);
            int skipKaro = helperMem(prices, index + 1, 1, dp);
            totalProfit = Math.max(buyKaro, skipKaro);
        }else{
            int sellKaro = prices[index] + helperMem(prices, index + 2, 1, dp);
            int skipKaro = helperMem(prices, index + 1, 0, dp);
            totalProfit = Math.max(sellKaro, skipKaro);
        }
        return dp[index][buy] = totalProfit;
    }

    private static int StockBuyAndSellFunc(int[] prices, boolean canBuy, boolean canSell, int index, int profit, Map<String, Integer> map) {
        if (index >= prices.length) {
            return profit;
        }

        int a = Integer.MIN_VALUE,b =Integer.MIN_VALUE,c = Integer.MIN_VALUE;
        if (canBuy) {
            a = StockBuyAndSellFunc(prices, false, true, index + 1, profit - prices[index], map);
        }

        if (canSell){
            b = StockBuyAndSellFunc(prices, false, false, index + 1, profit + prices[index], map);
        }

        if (!canBuy && !canSell) {
            canBuy= true;
            canSell= false;
        }

        c = StockBuyAndSellFunc(prices, canBuy, canSell, index + 1, profit, map);

        int value = Math.max(Math.max(a, b), c);
        return value;
    }
}
