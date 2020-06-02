package leetcode;

import leetcode.model.TreeNode;

/**
 * num:236
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author: TuGai
 * @createTime: 2020-06-02 21:22
 **/
public class LowestCommonAncestorOfBinaryTree {

    /**
     * 树的套路一般都是递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

}
