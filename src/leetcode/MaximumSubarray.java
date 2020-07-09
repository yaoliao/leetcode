package leetcode;

/**
 * 53. 最大子序和
 * <p>
 * num:53
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author: TuGai
 * @createTime: 2020-06-30 21:56
 **/
public class MaximumSubarray {

    public int maxSubArrayV1(int[] nums) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int minSum = 0;
        int max = nums[0];
        for (int i = 1; i < sum.length; i++) {
            max = Math.max(sum[i] - minSum, max);
            if (sum[i] < minSum) minSum = sum[i];
        }
        return max;
    }

    public int maxSubArrayV2(int[] nums) {
        // 已num[i] 结尾的最大连续子串和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
     * <p>
     * 如果 sum 小于 0 说明对后续的数组是没哟帮助的，所以可以直接丢弃
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }


    public static void main(String[] args) {
        MaximumSubarray subarray = new MaximumSubarray();
        System.out.println(subarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(subarray.maxSubArray(new int[]{-2, -3, -4}));
//        System.out.println(subarray.maxSubArray(new int[]{2, 3, 4}));
//        System.out.println(subarray.maxSubArray(new int[]{-2, 9}));
        System.out.println(subarray.maxSubArray(new int[]{-2, 9}));
    }

}
