package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * <p>
 * num:39
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author: TuGai
 * @createTime: 2020-07-31 11:51
 **/
public class CombinationSum {

    private List<List<Integer>> res = null;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new LinkedList<>());
        return res;
    }

    private void dfs(int[] candidates, int start, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new LinkedList<>(list));
        }

        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            if (target - c < 0) break;
            list.add(c);
            dfs(candidates, i, target - c, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {

        CombinationSum sum = new CombinationSum();
        System.out.println(sum.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
