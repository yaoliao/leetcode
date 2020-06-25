package leetcode;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * <p>
 * num:16
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * @author: TuGai
 * @createTime: 2020-06-24 00:13
 **/
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int num_lr = nums[l] + nums[r];
                if ((num_lr + nums[i]) < target) {
                    l++;
                } else if ((num_lr + nums[i]) > target) {
                    r--;
                } else {
                    return target;
                }
                res = Math.abs(target - (num_lr + nums[i])) < Math.abs(target - res) ? (num_lr + nums[i]) : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSumClosest sumClosest = new ThreeSumClosest();
        System.out.println(sumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(sumClosest.threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }

}
