package leetcode;

import leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * <p>
 * num:113
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author: TuGai
 * @createTime: 2020-07-17 21:27
 **/
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, new ArrayList<>(), sum);
        return resList;
    }

    private List<List<Integer>> resList = new ArrayList<>();

    private void dfs(TreeNode root, List<Integer> list, int sum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) resList.add(new ArrayList<>(list));
        dfs(root.left, list, sum - root.val);
        dfs(root.right, list, sum - root.val);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        PathSumII pathSumII = new PathSumII();
        TreeNode treeNode = TreeNode.deserialize("5,4,8,11,null,13,4,7,2,null,null,5,1");
        System.out.println(pathSumII.pathSum(treeNode, 22));
    }

}
