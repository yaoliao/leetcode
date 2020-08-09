package leetcode;

import leetcode.model.TreeNode;

/**
 * 687. 最长同值路径
 * <p>
 * num:687
 * https://leetcode-cn.com/problems/longest-univalue-path/
 *
 * @author: TuGai
 * @createTime: 2020-07-09 14:52
 **/
public class LongestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    private int max = 0;

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int resLeft = 0, resRight = 0;
        if (root.left != null && root.val == root.left.val) {
            resLeft = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            resRight = right + 1;
        }
        max = Math.max(max, resLeft + resRight);
        return Math.max(resLeft, resRight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode.Builder().val(5)
                .left(new TreeNode.Builder().val(4)
                        .left(new TreeNode.Builder().val(1).build())
                        .right(new TreeNode.Builder().val(1).build())
                        .build())
                .right(new TreeNode.Builder().val(5)
                        .left(new TreeNode.Builder().val(5).build())
                        .build()).build();
        LongestUnivaluePath path = new LongestUnivaluePath();
        System.out.println(path.longestUnivaluePath(root));
    }

}
