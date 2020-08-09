package leetcode;

import java.util.Arrays;

/**
 * 410. 分割数组的最大值
 * <p>
 * num:410
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 *
 * @author: TuGai
 * @createTime: 2020-07-25 22:04
 **/
public class SplitArrayLargestSum {

    public int splitArrayDp(int[] nums, int m) {
        int len = nums.length;

        // TODO 对于 「将数组分割为 m 段，求……」是动态规划题目常见的问法。 要记住记住记住
        // 表示 前 i 个数 分成 j 份，最大的和
        int[][] dp = new int[len + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int[] preSum = new int[len + 1];
        for (int i = 0; i < preSum.length - 1; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < m || j <= i; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], preSum[i] - preSum[k]));
                }
            }
        }
        return dp[len][m];
    }

    // ===================

    /**
     * 跟巧妙的方法--------> 利用 二分查找 + 贪心
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int l = max, r = sum;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (check(nums, mid, m)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int mid, int m) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return count <= m;
    }

}
