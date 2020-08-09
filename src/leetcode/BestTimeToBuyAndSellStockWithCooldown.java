package leetcode;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * <p>
 * num:309
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @author: TuGai
 * @createTime: 2020-07-10 00:08
 **/
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * ====== TODO 重点 重点 重点 重点 重点 重点重点 这里的状态转移可以这样理解：===================================
     * <p>
     * 一共有三种状态：空闲，持有，冻结
     * <p>
     * <p>
     * TODO =========================================================================
     * 状态转移：
     * <p>
     * (第 i 天状态)--(操作)-->(第 i + 1 天状态)
     * <p>
     * 空闲--(买入)-->持有
     * 空闲--(不动)-->空闲
     * 持有--(卖出)-->冻结
     * 持有--(不动)-->持有
     * 冻结--(不动)-->空闲
     * <p>
     * TODO =========================================================================
     * =========================================================================================================
     * <p>
     * <p>
     * 一、第i天不持股且没卖出的状态dp[i][0]，也就是我没有股票，而且还不是因为我卖了它才没有的，那换句话说是从i-1天到第i天转移时，它压根就没给我股票！所以i-1天一定也是不持有，那就是不持有的两种可能：i-1天不持股且当天没有卖出dp[i-1][0]；i-1天不持股但是当天卖出去了dp[i-1][2]；
     * 所以： dp[i][0]=max(dp[i-1][0],dp[i-1][2])
     * <p>
     * 二、第i天持股dp[i][1]，今天我持股，来自两种可能：
     * 1、要么是昨天我就持股，今天继承昨天的，也就是dp[i-1][1]，这种可能很好理解；
     * 2、要么：是昨天我不持股，今天我买入的，但前提是昨天我一定没卖！因为如果昨天我卖了，那么今天我不能交易！也就是题目中所谓“冷冻期”的含义，只有昨天是“不持股且当天没卖出”这个状态，我今天才能买入！所以是dp[i-1][0]-p[i]
     * 所以： dp[i][1]=max(dp[i-1][1],dp[i-1][0]-p[i])
     * <p>
     * 三、i天不持股且当天卖出了，这种就简单了，那就是说昨天我一定是持股的，要不然我今天拿什么卖啊，而持股只有一种状态，昨天持股的收益加上今天卖出得到的新收益，就是dp[i-1][1]+p[i]啦
     * 所以：dp[i][2]=dp[i-1][1]+p[i]
     * <p>
     * 总结：最后一天的最大收益有两种可能，而且一定是“不持有”状态下的两种可能，把这两种“不持有”比较一下大小，返回即可
     * <p>
     * 作者：jin-ai-yi
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/fei-zhuang-tai-ji-de-dpjiang-jie-chao-ji-tong-su-y/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len < 2) return 0;
        // i:天数  j: 0 不持有(不持股且能购买) 1 持有 2 冻结期(不持股且不能购买)
        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        /**
         * * (第 i 天状态)--(操作)-->(第 i + 1 天状态)
         * <p>
         * 空闲--(买入)-->持有
         * 空闲--(不动)-->空闲
         * 持有--(卖出)-->冻结
         * 持有--(不动)-->持有
         * 冻结--(不动)-->空闲
         */
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown time = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(time.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
