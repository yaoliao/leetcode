package leetcode.model;

/**
 * @author: TuGai
 * @createTime: 2020-06-01 23:47
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    private TreeNode(Builder builder) {
        val = builder.val;
        left = builder.left;
        right = builder.right;
    }

    /**
     *             5
     *       2          8
     *  10      22    9
     *        33
     * @return
     */
    public static TreeNode getTreeNode() {
        return new TreeNode.Builder().val(5)
                .left(new Builder().val(2)
                        .left(new Builder().val(10).build())
                        .right(new Builder().val(22)
                                .left(new Builder().val(33).build())
                                .build())
                        .build())
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
