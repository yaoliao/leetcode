package leetcode;

import leetcode.model.ListNode;

/**
 * 25. K 个一组翻转链表
 * <p>
 * num:25
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author: TuGai
 * @createTime: 2020-07-07 22:40
 **/
public class ReverseNodesInkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode vmNode = new ListNode(-1);
        vmNode.next = head;

        ListNode start = vmNode, end = vmNode;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode startNext = start.next;
            ListNode next = end.next;
            end.next = null;
            start.next = reversal(start.next);
            startNext.next = next;
            start = startNext;
            end = start;
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

    /*public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }*/

    public static void main(String[] args) {
        ReverseNodesInkGroup group = new ReverseNodesInkGroup();
        ListNode head = new ListNode(1);
        head.next(new ListNode(2)).next(new ListNode(3));
        ListNode reverse = group.reverseKGroup(head, 2);
        System.out.println(reverse);
    }
}
