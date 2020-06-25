package leetcode;

import leetcode.model.ListNode;

/**
 * 160. 相交链表
 * <p>
 * num:160
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author: TuGai
 * @createTime: 2020-06-24 21:02
 **/
public class IntersectionOfTwoLinkedLists {

    // ================  双指针法 =================
    // 以下两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。
    // 由于 B.length (=4) < A.length (=6)，pBpB 比 pApA 少经过 22 个结点，会先到达尾部。
    // 将 pBpB 重定向到 A 的头结点，pApA 重定向到 B 的头结点后，pBpB 要比 pApA 多走 2 个结点。因此，它们会同时到达交点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = ha == null ? headB : ha.next;
            hb = hb == null ? headA : hb.next;
        }
        return ha;
    }


}
