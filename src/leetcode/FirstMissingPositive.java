package leetcode;

/**
 * 41. 缺失的第一个正数
 * <p>
 * num:41
 * https://leetcode-cn.com/problems/first-missing-positive/
 *
 * @author: TuGai
 * @createTime: 2020-06-27 00:01
 **/
public class FirstMissingPositive {

    // ================  这 TMD 是脑经急转弯吗。。。。 ===============
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
