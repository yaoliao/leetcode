package leetcode;

import leetcode.model.ListNode;

/**
 * 142. 环形链表 II
 * <p>
 * num:142
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author: TuGai
 * @createTime: 2020-07-07 21:55
 **/
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;

        fast = head;
        while (fast == slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
