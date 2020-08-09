package leetcode;

import leetcode.model.TreeNode;

/**
 * 114. 二叉树展开为链表
 * <p>
 * num:114
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author: TuGai
 * @createTime: 2020-08-02 21:12
 **/
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList tree = new FlattenBinaryTreeToLinkedList();
        TreeNode node = TreeNode.createBySorted(new int[]{1, 2, 3, 4, 5, 6});
        tree.flatten(node);
        System.out.println("===");
    }


}
