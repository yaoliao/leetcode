package leetcode;

import leetcode.model.TreeNode;

/**
 * 110. 平衡二叉树
 * <p>
 * num:110
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author: TuGai
 * @createTime: 2020-07-24 23:05
 **/
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return res;
    }

    private boolean res = true;

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1) res = false;
        return Math.max(left, right) + 1;
    }

}
