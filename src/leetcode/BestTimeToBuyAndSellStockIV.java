package leetcode;

/**
 * 188. 买卖股票的最佳时机 IV
 * <p>
 * nun：188
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * @author: TuGai
 * @createTime: 2020-06-15 21:45
 **/
public class BestTimeToBuyAndSellStockIV {

    // ===================== 超出内存限制 =====================
    public int maxProfitV1(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) return 0;

        int len = prices.length;
        int[][][] bp = new int[len][k + 1][2];

        for (int i = 0; i < k + 1; i++) {
            bp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                //  第 i 天 交易 j 次 没有股票
                bp[i][j][0] = Math.max(bp[i - 1][j][0], bp[i - 1][j][1] + prices[i]);
                bp[i][j][1] = Math.max(bp[i - 1][j][1], bp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return bp[len - 1][k][0];
    }

    // ===================== 减少维度 =====================
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) return 0;

        int len = prices.length;
        if (k >= len / 2) {
            return greedy(prices, len);
        }

        int[][] bp = new int[k + 1][2];
        for (int i = 0; i < k + 1; i++) {
            bp[i][1] = -prices[0];
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                bp[j][0] = Math.max(bp[j][0], bp[j][1] + prices[i]);
                bp[j][1] = Math.max(bp[j][1], bp[j - 1][0] - prices[i]);
            }
        }
        return bp[k][0];
    }

    private int greedy(int[] prices, int len) {
        // 转换为股票系列的第 2 题，使用贪心算法完成，思路是只要有利润，就交易
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i - 1] < prices[i]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV best = new BestTimeToBuyAndSellStockIV();
//        int[] ints = {2, 4, 1};
        int[] ints = {3, 2, 6, 5, 0, 3};
        System.out.println(best.maxProfit(2, ints));
    }

}
