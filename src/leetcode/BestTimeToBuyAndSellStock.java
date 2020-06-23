package leetcode;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * num:121
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author: TuGai
 * @createTime: 2020-06-04 22:19
 **/
public class BestTimeToBuyAndSellStock {

    /**
     * 针对暴力枚举的优化
     * 只需要关心之前（不包括现在）看到的最低股价，于是在遍历的过程中，记录下之前看到的最低股价，就可以省去内层循环
     *
     * @param prices
     * @return
     */
    public static int maxProfitv1(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int p = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                p = Math.max(p, prices[i] - min);
            }
        }
        return p;
    }

    /**
     * 动态规划
     * <p>
     * 太牛逼了
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};
//        int[] ints = {7, 6, 4, 3, 1};
        int i = maxProfit(ints);
        System.out.println(i);
    }

}
