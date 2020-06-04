package leetcode;

/**
 * num:122
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author: TuGai
 * @createTime: 2020-06-04 21:39
 **/
public class BestTimeToBuyAndSellStockII {

    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int all = 0;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - pre > 0) all += (prices[i] - pre);
            pre = prices[i];
        }
        return all;
    }

    public static void main(String[] args) {
        int[] ints = {7, 6, 4, 3, 1};
//        int[] ints = {1, 2, 3, 4, 5};
        int i = maxProfit(ints);
        System.out.println(i);
    }

}
