package leetcode;

import leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * <p>
 * num:437
 * https://leetcode-cn.com/problems/path-sum-iii/
 *
 * @author: TuGai
 * @createTime: 2020-07-07 10:30
 **/
public class PathSumIII {

    /**
     * 利用前缀和 ---------  O(N)
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        // key：从跟节点到当前节点的和  value：数量
        Map<Integer, Integer> preCount = new HashMap<>();
        preCount.put(0, 1);
        return dfs(root, 0, preCount, sum);
    }

    private int dfs(TreeNode root, int sum, Map<Integer, Integer> preCount, int target) {
        if (root == null) return 0;

        sum = sum + root.val;
        Integer count = preCount.getOrDefault(sum - target, 0);
        preCount.put(sum, preCount.getOrDefault(sum, 0) + 1);
        int left = dfs(root.left, sum, preCount, target);
        int right = dfs(root.right, sum, preCount, target);
        preCount.put(sum, preCount.getOrDefault(sum, 0) - 1);
        return count + left + right;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode.Builder().val(1)
                .left(new TreeNode.Builder().val(4).build())
                .right(new TreeNode.Builder().val(5).build())
                .build();

        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum(root, 5));
    }

}
