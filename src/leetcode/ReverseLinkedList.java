package leetcode;

import leetcode.model.ListNode;

import java.util.Stack;

/**
 * 206. 反转链表
 * <p>
 * num:206
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author: TuGai
 * @createTime: 2020-06-24 21:28
 **/
public class ReverseLinkedList {

    // ============== 空间复杂度高 O(n) ===========
    public ListNode reverseListV1(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        ListNode vmNode = new ListNode(0);
        ListNode root = vmNode;
        while (!stack.isEmpty()) {
            vmNode.next = stack.pop();
            vmNode = vmNode.next;
        }
        vmNode.next = null;
        return root.next;
    }

    /**
     * 迭代法
     *
     * @param head
     * @return
     */
    public ListNode reverseListIterate(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    /**
     * 递归法
     *
     * @param head
     * @return
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next(new ListNode(2))
                .next(new ListNode(4))
                .next(new ListNode(7))
                .next(new ListNode(9));
        ReverseLinkedList list = new ReverseLinkedList();
        // 迭代
        System.out.println(root = list.reverseListIterate(root));

        // 递归
        System.out.println(list.reverseListRecursive(root));
    }


}
