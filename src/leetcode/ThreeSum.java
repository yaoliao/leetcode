package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * num:15
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author: TuGai
 * @createTime: 2020-06-01 22:31
 **/
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) return lists;

        Arrays.sort(nums); // 先排序
        int len = nums.length;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                int num = nums[i] + nums[l] + nums[r];
                if (num == 0) {
                    lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (num > 0) r--;
                else l++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(ints);
        System.out.println(lists);
    }

}
