package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * <p>
 * num:560
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * @author: TuGai
 * @createTime: 2020-06-28 23:41
 **/
public class SubarraySumEqualsK {

    /**
     * 暴力求解
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumForce(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }
        return res;
    }

    /**
     * 前缀和
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumV1(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        sum[0] = 0;
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) res++;
            }
        }
        return res;
    }

    /**
     * 前缀和优化
     * 利用 Map 将时间复杂度变为 O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);
        int preSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];

            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK sumEqualsK = new SubarraySumEqualsK();
        System.out.println(sumEqualsK.subarraySum(new int[]{1, 1, 1}, 2));
//        System.out.println(sumEqualsK.subarraySum(new int[]{1, 2, 3, 2, 1}, 5));
    }

}
