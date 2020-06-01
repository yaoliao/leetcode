package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * num:1
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author: TuGai
 * @createTime: 2020-06-01 22:09
 **/
public class TwoSum {

    /**
     * 利用 hash 时间复杂度 : O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            if (map.containsKey(i1)) {
                ints[0] = map.get(i1);
                ints[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        int target = 9;
        int[] ints1 = twoSum(ints, target);
        System.out.println(Arrays.toString(ints1));
    }

}
