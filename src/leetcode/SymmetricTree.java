package leetcode;

import leetcode.model.TreeNode;

/**
 * 101. 对称二叉树
 * <p>
 * num:101
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author: TuGai
 * @createTime: 2020-07-09 22:19
 **/
public class SymmetricTree {

    public boolean isSymmetricV1(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        defLeft(root.left, left);
        defRight(root.right, right);
        return left.toString().equals(right.toString());
    }

    private void defLeft(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null");
            return;
        }
        sb.append(root.val);
        defLeft(root.left, sb);
        defLeft(root.right, sb);
    }

    private void defRight(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null");
            return;
        }
        sb.append(root.val);
        defRight(root.right, sb);
        defRight(root.left, sb);
    }


    // ===============

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }


    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        System.out.println(tree.isSymmetric(new TreeNode(1)));
    }

}
