package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1248. 统计「优美子数组」
 * <p>
 * num:1248
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 *
 * @author: TuGai
 * @createTime: 2020-06-28 23:16
 **/
public class CountNumberOfNiceSubarrays {

    /**
     * 用 map 只击败 7% 。。。。
     * 用优化后的代码击败 100% 。
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarraysV1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) != 0) {
                preSum++;
            }
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    /**
     * 优化后的代码，用 prefixCnt 数组代替 map
     * <p>
     * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/solution/hua-dong-chuang-kou-qian-zhui-he-bi-xu-miao-dong-b/
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        // 数组 prefixCnt 的下标是前缀和（即当前奇数的个数），值是前缀和的个数。
        int[] prefixCnt = new int[nums.length + 1];
        prefixCnt[0] = 1;
        // 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
        // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
        int res = 0, sum = 0;
        for (int num : nums) {
            sum += num & 1;
            prefixCnt[sum]++;
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        CountNumberOfNiceSubarrays number = new CountNumberOfNiceSubarrays();
        System.out.println(number.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(number.numberOfSubarrays(new int[]{2, 4, 6}, 1));
        System.out.println(number.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }

}
