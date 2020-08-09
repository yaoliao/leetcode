package leetcode;

import leetcode.model.ListNode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * num:24
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author: TuGai
 * @createTime: 2020-07-09 21:46
 **/
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode vmNode = new ListNode(-1);
        vmNode.next = head;

        ListNode start = vmNode;
        ListNode root = vmNode;
        int k = 2;
        while (root.next != null) {
            ListNode pre = root.next;
            for (int i = 0; i < k && root != null; i++) {
                root = root.next;
            }
            if (root == null) break;

            ListNode next = root.next;
            root.next = null;
            start.next = reversal(start.next);
            pre.next = next;
            start = pre;
            root = pre;
        }
        return vmNode.next;
    }

    private ListNode reversal(ListNode root) {
        ListNode pre = null;
        while (root != null) {
            ListNode next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next(new ListNode(2)).next(new ListNode(3)).next(new ListNode(4));
        SwapNodesInPairs nodes = new SwapNodesInPairs();
        System.out.println(nodes.swapPairs(node));
    }

}
