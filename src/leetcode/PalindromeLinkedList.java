package leetcode;

import leetcode.model.ListNode;

/**
 * 234. 回文链表
 * <p>
 * num:234
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author: TuGai
 * @createTime: 2020-06-24 22:00
 **/
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode s = head, f = head;

        //  双指针找中点, 并且在查找过程中 翻转前半部分的链表
        ListNode pre = null;
        while (f != null && f.next != null) {
            f = f.next.next;

            ListNode tmp = s.next;
            s.next = pre;
            pre = s;
            s = tmp;
        }

        /*
          1、链表是偶数时  (快指针指向 null)

                  ↓ 慢指针
          1 - 2 - 3 - 4 - null
                           ↑ 快指针

          2、 链表是奇数时 (快指针指向 最后的节点)

                  ↓ 慢指针
          1 - 2 - 3 - 4 - 5 - null
                          ↑ 快指针
         */

        // 奇数节点
        if (f != null) {
            s = s.next;
        }
        while (s != null) {
            if (pre.val != s.val) return false;
            pre = pre.next;
            s = s.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next(new ListNode(1))
                .next(new ListNode(4))
                .next(new ListNode(1))
                .next(new ListNode(0));

        PalindromeLinkedList list = new PalindromeLinkedList();
        System.out.println(list.isPalindrome(listNode));
    }

}
