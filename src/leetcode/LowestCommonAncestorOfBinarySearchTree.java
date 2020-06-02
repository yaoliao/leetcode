package leetcode;

import leetcode.model.TreeNode;

/**
 * num:235
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * 利用了二叉树的特新，左子树都小于根节点，右子树都大于根节点
 *
 * @author: TuGai
 * @createTime: 2020-06-02 20:40
 **/
public class LowestCommonAncestorOfBinarySearchTree {

    /**
     * 利用循环
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorv1(TreeNode root, TreeNode p, TreeNode q) {
        int lv = p.val;
        int rv = q.val;
        TreeNode result = null;
        while (root != null) {
            int val = root.val;
            if (rv < val && lv < val) root = root.left;
            else if (rv > val && lv > val) root = root.right;
            else {
                result = root;
                break;
            }
        }
        return result;
    }

    /**
     * 递归算法
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }


    public static void main(String[] args) {

    }
}
