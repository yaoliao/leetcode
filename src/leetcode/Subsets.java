package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * num:78
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author: TuGai
 * @createTime: 2020-07-18 22:54
 **/
public class Subsets {

    public List<List<Integer>> subsetsV(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        help(nums, 0, resList, new ArrayList<>());
        return resList;
    }

    private void help(int[] nums, int index, List<List<Integer>> resList, List<Integer> list) {
        resList.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            help(nums, i + 1, resList, list);
            list.remove(list.size() - 1);
        }
    }

    //=========
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int num = (1 << len) - 1;

        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            List<Integer> list = new ArrayList<>();
            int j = 1;
            int index = 0;
            while (j <= num) {
                if ((i & j) != 0) list.add(nums[index]);
                j = j << 1;
                index++;
            }
            resList.add(list);
        }
        return resList;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }


}
