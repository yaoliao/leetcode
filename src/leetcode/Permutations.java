package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * num:46
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author: TuGai
 * @createTime: 2020-07-05 22:12
 **/
public class Permutations {

    /**
     * 回溯
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteV(int[] nums) {
        int len = nums.length;
        if (len == 0) return Collections.emptyList();
        List<List<Integer>> lists = new ArrayList<>();
        helper(nums, 0, lists, new ArrayList<>());
        return lists;
    }

    private void helper(int[] nums, int dep, List<List<Integer>> lists, List<Integer> list) {
        if (dep == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(nums, dep + 1, lists, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) return Collections.emptyList();
        List<List<Integer>> lists = new ArrayList<>();
        dfs(nums, 0, lists);
        return lists;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> lists) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            lists.add(list);
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            dfs(nums, i + 1, lists);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1, 2, 3}));
//        System.out.println(permutations.permute(new int[]{1, 2}));
    }
}
