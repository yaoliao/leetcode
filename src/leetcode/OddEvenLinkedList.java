package leetcode;

import leetcode.model.ListNode;

/**
 * 328. 奇偶链表
 * <p>
 * num:328
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 *
 * @author: TuGai
 * @createTime: 2020-06-24 23:02
 **/
public class OddEvenLinkedList {

    // ================  一点都不美观 ==================
    public ListNode oddEvenListV1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node1 = head, node1Head = head; // 奇数
        ListNode node2 = head.next, node2Head = head.next; // 偶数
        head = head.next.next;
        while (head != null && head.next != null) {
            node1.next = head;
            node2.next = head.next;

            node1 = node1.next;
            node2 = node2.next;
            head = head.next.next;
        }

        // 奇数个节点
        if (head != null) {
            node1.next = head;
            node1 = node1.next;
            node2.next = null;
        }

        node1.next = node2Head;
        return node1Head;
    }

    // ================== 简洁明了 ======================
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next(new ListNode(2))
                .next(new ListNode(3))
                .next(new ListNode(4))
                .next(new ListNode(5));

        OddEvenLinkedList list = new OddEvenLinkedList();
        System.out.println(list.oddEvenList(listNode));
    }

}
