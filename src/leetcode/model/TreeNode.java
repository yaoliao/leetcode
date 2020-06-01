package leetcode.model;

/**
 * @author: TuGai
 * @createTime: 2020-06-01 23:47
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    private TreeNode(Builder builder) {
        val = builder.val;
        left = builder.left;
        right = builder.right;
    }

    public static TreeNode getTreeNode() {
        return new TreeNode.Builder().val(5)
                .left(new TreeNode.Builder().val(2).build())
                .right(new TreeNode.Builder().val(8)
                        .left(new TreeNode.Builder().val(9).build())
                        .build())
                .build();
    }


    public static final class Builder {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public Builder() {
        }

        public Builder val(int value) {
            val = value;
            return this;
        }

        public Builder left(TreeNode val) {
            left = val;
            return this;
        }

        public Builder right(TreeNode val) {
            right = val;
            return this;
        }

        public TreeNode build() {
            return new TreeNode(this);
        }
    }
}
