package leetcode;

import leetcode.model.TreeNode;

/**
 * num:776
 *
 * @author: TuGai
 * @createTime: 2020-07-13 15:48
 **/
public class SplitBst {

    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        TreeNode[] treeNodes;
        if (root.val <= V) {
            treeNodes = splitBST(root.right, V);
            root.right = treeNodes[0];
            treeNodes[0] = root;
        } else {
            treeNodes = splitBST(root.left, V);
            root.left = treeNodes[1];
            treeNodes[1] = root;
        }
        return treeNodes;
    }


    /**
     * [10,5,20,3,9,15,25,null,null,8,null,null,null,null,null,6,null,null,7]
     * 6
     *
     * @param args
     */
    public static void main(String[] args) {
        SplitBst bst = new SplitBst();

        /*String str = "10,5,20,3,9,15,25,null,null,8,null,null,null,null,null,6,null,null,7";
        TreeNode treeNode = TreeNode.deserialize(str);
        TreeNode[] treeNodes = bst.splitBST(treeNode, 6);*/

        TreeNode node = TreeNode.createBySorted(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode[] treeNodes1 = bst.splitBST(node, 2);

//        TreeNode[] treeNodes1 = bst.splitBSTV1(treeNode, 6);
        System.out.println("=");
    }

}
