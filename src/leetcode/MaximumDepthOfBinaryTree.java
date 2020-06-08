package leetcode;

import leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * num:104
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author: TuGai
 * @createTime: 2020-06-06 19:47
 **/
public class MaximumDepthOfBinaryTree {

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public int maxDepthV1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int dep = 0;
        int count = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (--count == 0) {
                count = queue.size();
                dep++;
            }
        }
        return dep;
    }

    /**
     * dfs
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
