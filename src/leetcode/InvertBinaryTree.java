package leetcode;

import leetcode.model.TreeNode;

/**
 * 226. 翻转二叉树
 * <p>
 * num:226
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author: TuGai
 * @createTime: 2020-07-06 22:29
 **/
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return root;
        TreeNode left = dfs(root.left);
        root.left = dfs(root.right);
        root.right = left;
        return root;
    }

}
