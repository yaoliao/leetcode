package leetcode;

/**
 * 312. 戳气球
 * <p>
 * num:312
 * https://leetcode-cn.com/problems/burst-balloons/
 *
 * @author: TuGai
 * @createTime: 2020-07-18 22:03
 **/
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] tmpNums = new int[len + 2];
        tmpNums[0] = tmpNums[len + 1] = 1;
        for (int i = 1; i < tmpNums.length - 1; i++) {
            tmpNums[i] = nums[i - 1];
        }

        // dp 定义：下标从 i 到 j 的数组的最大的硬币数（i，j）左右开区间
        int[][] dp = new int[len + 2][len + 2];

        for (int i = len; i >= 0; i--) {
            for (int j = i + 1; j < len + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + tmpNums[i] * tmpNums[k] * tmpNums[j]);
                }
            }
        }
        return dp[0][len + 1];
    }
}
