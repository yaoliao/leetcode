package leetcode;

import leetcode.model.TreeNode;

/**
 * 100. 相同的树
 * <p>
 * num:100
 * https://leetcode-cn.com/problems/same-tree/
 *
 * @author: TuGai
 * @createTime: 2020-08-07 23:28
 **/
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

}
