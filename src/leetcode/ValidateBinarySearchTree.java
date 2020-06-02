package leetcode;

import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * num:98
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author: TuGai
 * @createTime: 2020-06-01 23:48
 **/
public class ValidateBinarySearchTree {


    // ================== 方法1 ======================

    /**
     * 中序遍历二叉树，然后判断是不是升序
     *
     * @param root
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        List<Long> list = new ArrayList<>();
        traverse(root, list);

        // 不能有重复的数字
        if (list.size() != new HashSet<>(list).size()) return false;

        if (list.size() == 1) return true;
        long before = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - before < 0) return false;
            before = list.get(i);
        }
        return true;
    }

    /**
     * 中序遍历(如果是二叉搜索树，则遍历的结果应该是递增的)
     *
     * @param root
     * @param list
     */
    private static void traverse(TreeNode root, List<Long> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        list.add((long) root.val);
        traverse(root.right, list);
    }

    // ================== 方法2 ======================

    /**
     * 递归，和前一个节点比较
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isTree(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private static boolean isTree(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return isTree(root.left, root.val, min) && isTree(root.right, max, root.val);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode.Builder().val(5)
                .left(new TreeNode.Builder().val(2).build())
                .right(new TreeNode.Builder().val(8)
                        .left(new TreeNode.Builder().val(7).build())
                        .build())
                .build();
        System.out.println(isValidBST(treeNode));
    }

}
