package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * num:229
 * https://leetcode-cn.com/problems/majority-element-ii/
 *
 * @author: TuGai
 * @createTime: 2020-06-03 20:22
 **/
public class MajorityElementII {

    /**
     * 1. 找到数组中出现次数大于 1/3 的数, 可能有一个, 也可能有2个, 我们先假定有两个分别是 x,y 那么可以将集合分为 x, y, other 三类数
     * 2. 如果将 x, y, other 一一对应, 那么x, y必将有剩余, 我们统计数组中3个不同的数, 使用2个坑, 对于每个数nums[i]:
     * 2.1 如果一个坑是空的, 且nums[i] 不在另一个坑内, count[index] ++;
     * 2.2 如果nums[i] 在两个坑的任一个, 那么count[index] ++;
     * 2.3 如果坑都有值, 且都与nums[i] 不相等, 说明找到一个互不相同的三元组, 那么count[0]--, count[1]--;
     * <p>
     * 3. 最后2个坑内的值就是候选值, 重新验证一下, 出现次数 > n/3 的就是结果之一.
     * <p>
     *
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {

        List<Integer> list = new ArrayList<>();

        int cand1 = 0, cand2 = 0;
        int c1 = 0, c2 = 0;

        for (int num : nums) {

            if (cand1 == num) {
                c1++;
                continue;
            }

            if (cand2 == num) {
                c2++;
                continue;
            }

            if (c1 == 0) {
                c1++;
                cand1 = num;
                continue;
            }

            if (c2 == 0) {
                c2++;
                cand2 = num;
                continue;
            }

            c1--;
            c2--;
        }

        c1 = c2 = 0;

        for (int num : nums) {
            if (num == cand1) c1++;
            if (num == cand2) c2++;
        }

        int length = nums.length;

        if (c1 > length / 3) list.add(cand1);
        if (c2 > length / 3 && !list.contains(cand2)) list.add(cand2);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
//        int[] nums = {3, 2, 3};
        List<Integer> list = majorityElement(nums);
        System.out.println(list);
    }

}
