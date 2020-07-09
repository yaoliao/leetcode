package leetcode;

/**
 * 209. 长度最小的子数组
 * <p>
 * num:209
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @author: TuGai
 * @createTime: 2020-06-28 00:11
 **/
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                len = Math.min((i - l) + 1, len);
                if (l >= i) break;
                sum -= nums[l];
                l++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum sum = new MinimumSizeSubarraySum();
        System.out.println(sum.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(sum.minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));
    }

}
