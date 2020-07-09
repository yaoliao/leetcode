package leetcode;

import leetcode.model.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * <p>
 * num:108
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author: TuGai
 * @createTime: 2020-07-03 00:10
 **/
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) return null;
        return help(nums, 0, len);
    }

    private TreeNode help(int[] nums, int l, int r) {
        if (l >= r) return null;
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums, l, mid);
        node.right = help(nums, mid + 1, r);
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree tree = new ConvertSortedArrayToBinarySearchTree();
        TreeNode node = tree.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(node);
    }

}
