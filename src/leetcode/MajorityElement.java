package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * num:169
 * https://leetcode-cn.com/problems/majority-element/
 *
 * @author: TuGai
 * @createTime: 2020-06-02 23:55
 **/
public class MajorityElement {

    /**
     * 使用 map 的算法
     *
     * @param nums
     * @return
     */
    public int majorityElementWithMap(int[] nums) {

        //Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        int i = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= i) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 使用排序的算法
     * 因为题目规定一定存在 众数 所以排序后的中间值一定是众数
     *
     * @param nums
     * @return
     */
    public int majorityElementBySort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     * 最骚的解法。。。。。。。。。。。。。。
     * <p>
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     * <p>
     * 为何这行得通呢？
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     * <p>
     * 无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。
     * <p>
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else if (--count == 0) {
                num = nums[i];
                count = 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {

    }

}
