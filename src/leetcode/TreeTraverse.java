package leetcode;

import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的遍历
 *
 * @author: TuGai
 * @createTime: 2020-06-05 00:51
 **/
public class TreeTraverse {

    /**
     * ==========================================================================================
     *
     * #######  深度优先搜索策略可以根据根节点、左孩子和右孩子的相对顺序被细分为前序遍历，中序遍历和后序遍历
     *
     * ==========================================================================================
     */

    /**
     * 深度优先(前序遍历)
     *
     * @param root
     * @param list
     */
    private static void preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    }

    /**
     * 深度优先(中序遍历)
     *
     * @param root
     * @param list
     */
    private static void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }

    /**
     * 深度优先(后序遍历)
     *
     * @param root
     * @param list
     */
    private static void postOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postOrderTraversal(root.left, list);
        postOrderTraversal(root.right, list);
        list.add(root.val);
    }

    //================================================================================

    /**
     * 广度优先
     *
     * @param root
     * @param list
     */
    public static void bfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }


    public static void main(String[] args) {

        /**
         *         5
         *    2        8
         * 10   22   9
         *    33
         */
        TreeNode root = new TreeNode.Builder().val(5)
                .left(new TreeNode.Builder().val(2)
                        .left(new TreeNode.Builder().val(10).build())
                        .right(new TreeNode.Builder().val(22)
                                .left(new TreeNode.Builder().val(33).build())
                                .build())
                        .build())
                .right(new TreeNode.Builder().val(8)
                        .left(new TreeNode.Builder().val(9).build())
                        .build())
                .build();

        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        list.forEach(e -> System.out.print(e + " "));

        System.out.println();
        System.out.println(" ==========  bfs  ============");
        list.clear();
        bfs(root, list);
        list.forEach(e -> System.out.print(e + " "));
    }


}
