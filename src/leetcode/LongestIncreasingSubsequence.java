package leetcode;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * <p>
 * num:300
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author: TuGai
 * @createTime: 2020-06-16 21:13
 **/
public class LongestIncreasingSubsequence {

    // ==================== 时间复杂度 O(n2) =====================

    public int lengthOfLISV1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    // ==================== 利用二分查找 时间复杂度 O(NlogN) =====================

    /**
     * 这样找出来的结果未必就是真实的结果 数组结果，但是数组长度确实一致的
     *
     * @param nums
     * @return
     */
    public int lengthOfLISBs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] ints = new int[nums.length];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(ints, 0, len, nums[i]);
            if (index < 0) index = -index - 1;
            ints[index] = nums[i];
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        int[] ints = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(subsequence.lengthOfLIS(ints));

    }

}
