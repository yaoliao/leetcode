package leetcode;

/**
 * 167. 两数之和 II - 输入有序数组
 * <p>
 * num:167
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author: TuGai
 * @createTime: 2020-07-08 22:01
 **/
public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) return new int[]{l + 1, r + 1};
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[0];
    }
}
