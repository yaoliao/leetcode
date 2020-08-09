package leetcode;

import leetcode.model.ListNode;

/**
 * 61. 旋转链表
 * <p>
 * num:61
 * https://leetcode-cn.com/problems/rotate-list/
 *
 * @author: TuGai
 * @createTime: 2020-07-16 23:36
 **/
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        ListNode root = head;
        int count = 1;
        while (root.next != null) {
            root = root.next;
            count++;
        }
        ListNode tail = root;

        if (count == k) return head;
        if (count < k) k = k % count;
        if (k == 0) return head;

        root = head;
        ListNode pre = head;
        int i = 0;
        while (root != null) {
            if (i > k) {
                pre = pre.next;
            }
            i++;
            root = root.next;
        }
        ListNode next = pre.next;
        pre.next = null;
        tail.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
//        root.next(new ListNode(1)).next(new ListNode(2));

        RotateList rotateList = new RotateList();
        System.out.println(rotateList.rotateRight(root, 2));
    }

}
