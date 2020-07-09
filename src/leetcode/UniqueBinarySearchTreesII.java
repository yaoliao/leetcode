package leetcode;

import leetcode.model.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * <p>
 * num:95
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * @author: TuGai
 * @createTime: 2020-07-03 22:14
 **/
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.emptyList();
        List<TreeNode> helper = helper(1, n);
        return helper;
    }

    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> list = new LinkedList<>();
        if (l > r) {
            list.add(null);
            return list;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftNodes = helper(l, i - 1);
            List<TreeNode> rightNodes = helper(i + 1, r);

            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII treesII = new UniqueBinarySearchTreesII();
        List<TreeNode> list = treesII.generateTrees(2);
        System.out.println(list);
    }
}
