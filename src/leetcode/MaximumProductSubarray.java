package leetcode;

/**
 * 152. 乘积最大子数组
 * <p>
 * num:152
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * @author: TuGai
 * @createTime: 2020-06-14 22:02
 **/
public class MaximumProductSubarray {

    // ============ 动态规划 ==================

    public int maxProductV1(int[] nums) {

        // i:从左到 i 的长度
        // j： 0: 最大的值 1：最小的值(负数)
        int[][] ints = new int[nums.length][2];

        ints[0][0] = nums[0]; // 正的最大值
        ints[0][1] = nums[0]; // 负的最大值
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num >= 0) {
                ints[i][0] = Math.max(num, ints[i - 1][0] * num);
                ints[i][1] = Math.min(num, ints[i - 1][1] * num);
            } else {
                ints[i][0] = Math.max(num, ints[i - 1][1] * num);
                ints[i][1] = Math.min(num, ints[i - 1][0] * num);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ints.length; i++) {
            int n = ints[i][0];
            if (n > max) max = n;
        }
        return max;
    }

    // ============ 动态规划 优化 空间复杂度 ==================

    public int maxProduct(int[] nums) {
        int[] ints = new int[2];

        // 滚动变量
        int curMax;
        int curMin;
        ints[0] = nums[0]; // 正的最大值
        ints[1] = nums[0]; // 负的最大值
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num >= 0) {
                curMax = Math.max(num, ints[0] * num);
                curMin = Math.min(num, ints[1] * num);
            } else {
                curMax = Math.max(num, ints[1] * num);
                curMin = Math.min(num, ints[0] * num);
            }
            ints[0] = curMax;
            ints[1] = curMin;

            res = Math.max(res, curMax);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray subarray = new MaximumProductSubarray();
//        int[] ints = {2, 3, -2, 4};
//        int[] ints = {-2, 0, -1};
        int[] ints = {0, 2};
        System.out.println(subarray.maxProduct(ints));
    }

}
