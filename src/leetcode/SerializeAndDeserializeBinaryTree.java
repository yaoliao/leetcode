package leetcode;

import leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 * <p>
 * num：297
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author: TuGai
 * @createTime: 2020-06-16 00:04
 **/
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        bfs(root, sb);
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    private void bfs(TreeNode root, StringBuilder sb) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null").append(",");
                continue;
            }
            sb.append(node.val).append(",");
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] num = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(num[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            String s = num[i++];
            if (!"null".equals(s)) {
                tree.left = new TreeNode(Integer.valueOf(s));
                queue.add(tree.left);
            }
            s = num[i++];
            if (!"null".equals(s)) {
                tree.right = new TreeNode(Integer.valueOf(s));
                queue.add(tree.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree tree = new SerializeAndDeserializeBinaryTree();
        String rootStr = tree.serialize(TreeNode.getTreeNode());
        System.out.println(rootStr);
        TreeNode root = tree.deserialize(rootStr);
        System.out.println(root);
    }

}
