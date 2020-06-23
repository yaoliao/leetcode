package leetcode;

import leetcode.model.ListNode;

/**
 * 21. 合并两个有序链表
 * <p>
 * num:21
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author: TuGai
 * @createTime: 2020-06-21 23:14
 **/
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode vmNode = new ListNode(0);
        ListNode root = vmNode;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int val2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (val1 > val2) {
                root.next = new ListNode(val2);
                if (l2 != null)
                    l2 = l2.next;
            } else {
                root.next = new ListNode(val1);
                if (l1 != null)
                    l1 = l1.next;
            }
            root = root.next;
        }
        return vmNode.next;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        root1.next(new ListNode(4))
                .next(new ListNode(14));

        ListNode root2 = new ListNode(2);
        root2.next(new ListNode(7))
                .next(new ListNode(16))
                .next(new ListNode(74));

        MergeTwoSortedLists lists = new MergeTwoSortedLists();
        ListNode listNode = lists.mergeTwoLists(root1, root2);
        System.out.println(listNode);
    }

}
