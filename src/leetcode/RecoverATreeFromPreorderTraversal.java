package leetcode;

import leetcode.model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 1028. 从先序遍历还原二叉树
 * <p>
 * num:1028
 * https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 *
 * @author: TuGai
 * @createTime: 2020-06-18 00:10
 **/
public class RecoverATreeFromPreorderTraversal {

    // ===================== 利用 stack ,自己写的垃圾代码,又慢又长就是一坨💩啊 ========================

    public TreeNode recoverFromPreorderV1(String S) {
        if (S == null || S.length() == 0) return null;

        Stack<TreeNode> stack = new Stack<>();
        int dep = 0;
        int before = 0;
        StringBuilder sb = new StringBuilder();
        TreeNode root = null;
        for (int j = 0; j < S.length(); j++) {
            char c = S.charAt(j);
            if (c == '-') {
                dep++;
                continue;
            }
            sb.append(c);
            if (j + 1 < S.length() && S.charAt(j + 1) != '-') {
                continue;
            }
            if (root == null) {
                root = new TreeNode(Integer.valueOf(sb.toString()));
                stack.add(root);
                sb.delete(0, sb.length());
                continue;
            }
            if (dep == before) {
                stack.pop(); // 左节点
                TreeNode treeNode = stack.peek();
                treeNode.right = new TreeNode(Integer.valueOf(sb.toString()));
                stack.add(treeNode.right);
            } else if (dep > before) {
                TreeNode treeNode = stack.peek();
                treeNode.left = new TreeNode(Integer.valueOf(sb.toString()));
                stack.add(treeNode.left);
            } else {
                for (int k = 0; k <= before - dep; k++) {
                    stack.pop();
                }
                TreeNode treeNode = stack.peek();
                treeNode.right = new TreeNode(Integer.valueOf(sb.toString()));
                stack.add(treeNode.right);
            }
            before = dep;
            dep = 0;
            sb.delete(0, sb.length());
        }
        return root;
    }

    // ========================  利用 Deque ==================
    public TreeNode recoverFromPreorderV2(String S) {
        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            while (S.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }

    // =========================   递归 =============================
    public TreeNode recoverFromPreorder(String S) {
        char[] str = S.toCharArray();
        return dfs(str, 0);
    }

    int cur = 0, d = 0;

    public TreeNode dfs(char[] str, int depth) {
        int val = 0; //记录根节点值
        for (; cur < str.length && str[cur] != '-'; cur++) {  //循环结束后cur指向根节点的子节点值前面的-
            val = val * 10 + str[cur] - '0';
        }
        d = 0;  //用于记录该子节点深度所以每次dfs置0
        for (; cur < str.length && str[cur] == '-'; cur++) {
            d++;
        }
        TreeNode root = new TreeNode(val);  //构建根节点
        if (d > depth) root.left = dfs(str, d);  //构建左子树
        if (d > depth) root.right = dfs(str, d);
        return root;
    }


    public static void main(String[] args) {
        RecoverATreeFromPreorderTraversal tree = new RecoverATreeFromPreorderTraversal();
        TreeNode treeNode = tree.recoverFromPreorder("1-20--35--44-5--6--7");
//        TreeNode treeNode = tree.recoverFromPreorder("1-2--3---4-5--6---7");
//        TreeNode treeNode = tree.recoverFromPreorder("1-401--349---90--88");
//        TreeNode treeNode = tree.recoverFromPreorder("1-401--349---90--88");
//        TreeNode treeNode = tree.recoverFromPreorder("1-401--349--90---88");
//        TreeNode treeNode = tree.recoverFromPreorder("10-7--8");
//        TreeNode treeNode = tree.recoverFromPreorder("8-6--9---10--4-7");
        System.out.println(treeNode);
        SerializeAndDeserializeBinaryTree tree1 = new SerializeAndDeserializeBinaryTree();
        System.out.println(tree1.serialize(treeNode));
    }

}
