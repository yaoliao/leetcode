package leetcode;

import leetcode.model.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * num:124
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * @author: TuGai
 * @createTime: 2020-06-21 00:28
 **/
public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max = root.val;
        maxGain(root);
        return max;
    }

    public int maxGain(TreeNode root) {
        if (root == null) return 0;

        int l = Math.max(maxGain(root.left), 0);
        int r = Math.max(maxGain(root.right), 0);

        int i = l + r + root.val;
        if (i > max) max = i;

        return root.val + Math.max(l, r);
    }
}
