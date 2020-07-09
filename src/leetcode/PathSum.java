package leetcode;

import leetcode.model.TreeNode;

/**
 * 112. 路径总和
 * <p>
 * num:112
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author: TuGai
 * @createTime: 2020-07-07 00:59
 **/
public class PathSum {

    /**
     * ============= 垃圾代码 ==================
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumV(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode root, int sum, int target) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum + root.val == target;
        return dfs(root.left, sum + root.val, target) || dfs(root.right, sum + root.val, target);
    }

    /**
     * 优秀
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode.Builder().val(-2)
//                .left(new TreeNode.Builder().val(2).build())
                .right(new TreeNode.Builder().val(-3).build())
                .build();
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(root, -5));
    }

}
