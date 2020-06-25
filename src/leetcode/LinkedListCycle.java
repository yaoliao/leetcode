package leetcode;

import leetcode.model.ListNode;

/**
 * 141. 环形链表
 * <p>
 * num:141
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author: TuGai
 * @createTime: 2020-06-23 22:14
 **/
public class LinkedListCycle {

    // ============= 双指针 写的还是没有官方的好啊。。。。 =====================
    public boolean hasCycleV(ListNode head) {
        if (head == null) return false;
        if (head.next == null || head.next.next == null) return false;
        ListNode node1 = head.next;
        ListNode node2 = head.next.next;

        while (true) {
            if (node2.next == null || node2.next.next == null) return false;
            if (node1 == node2) return true;
            node1 = node1.next;
            node2 = node2.next.next;
        }
    }

    // ============= 双指针  =====================
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // copy official write again
    public boolean hasCycleCopy(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }


}
