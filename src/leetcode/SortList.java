package leetcode;

import leetcode.model.ListNode;

/**
 * 148. 排序链表
 * <p>
 * num:148
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author: TuGai
 * @createTime: 2020-06-23 22:29
 **/
public class SortList {

    // =================== 归并排序 =======================
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return margeSort(head);
    }

    private ListNode margeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode s = head, f = head.next;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode r = margeSort(s.next);
        s.next = null;
        ListNode l = margeSort(head);
        return marge(l, r);
    }

    private ListNode marge(ListNode l, ListNode r) {
        ListNode vmNode = new ListNode(0);
        ListNode head = vmNode;
        while (l != null && r != null) {
            if (l.val < r.val) {
                vmNode.next = l;
                l = l.next;
            } else {
                vmNode.next = r;
                r = r.next;
            }
            vmNode = vmNode.next;
        }
        vmNode.next = l == null ? r : l;
        return head.next;
    }


    // =================== 快排 TODO ！！！！！！  多看两边  ！！！！！！ =======================
    public ListNode sortListV1(ListNode head) {
        if (head == null || head.next == null) return head;
        // 没有条件，创造条件。自己添加头节点，最后返回时去掉即可。
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        return quickSort(newHead, null);
    }

    // 带头结点的链表快速排序
    private ListNode quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end || head.next.next == end) return head;
        // 将小于划分点的值存储在临时链表中
        ListNode tmpHead = new ListNode(-1);
        // partition为划分点，p为链表指针，tp为临时链表指针
        ListNode partition = head.next, p = partition, tp = tmpHead;
        // 将小于划分点的结点放到临时链表中
        while (p.next != end) {
            if (p.next.val < partition.val) {
                tp.next = p.next;
                tp = tp.next;
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        // 合并临时链表和原链表，将原链表接到临时链表后面即可
        tp.next = head.next;
        // 将临时链表插回原链表，注意是插回！（不做这一步在对右半部分处理时就断链了）
        head.next = tmpHead.next;
        quickSort(head, partition);
        quickSort(partition, end);
        // 题目要求不带头节点，返回结果时去除
        return head.next;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(3);
        node.next(new ListNode(8)).next(new ListNode(2)).next(new ListNode(4));

        SortList sortList = new SortList();
        ListNode listNode = sortList.sortList(node);
        System.out.println(listNode);
    }
}
