package leetcode;

import leetcode.model.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 19. 删除链表的倒数第N个节点
 * <p>
 * num:19
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author: TuGai
 * @createTime: 2020-06-21 22:27
 **/
public class RemoveNthNodeFromEndOfList {

    /**
     * ##################  ！！！！！ 关键点关键点 ！！！！！！##################
     * #################  链表的题目 添加一个虚拟头节点，可以减少很多不必要的判断(判空等等等)  ##########
     */

    //==================== 并不需要 queue 来存储中间的节点，可以优化 =============
    public ListNode removeNthFromEndV1(ListNode head, int n) {
        ListNode vmNode = new ListNode(0);
        vmNode.next = head;
        Queue<ListNode> queue = new LinkedList<>();
        queue.add(vmNode);
        ListNode listNode = vmNode;
        while (listNode.next != null) {
            queue.add(listNode.next);
            if (queue.size() > n + 1) {
                queue.poll();
            }
            listNode = listNode.next;
        }
        ListNode node = queue.poll();
        node.next = node.next.next;
        return vmNode.next;
    }

    // ==================== 优化后只存储两个需要的节点 =============

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        RemoveNthNodeFromEndOfList endOfList = new RemoveNthNodeFromEndOfList();
        ListNode listNode1 = endOfList.removeNthFromEnd(listNode, 2);
        System.out.println(listNode1);
    }
}
