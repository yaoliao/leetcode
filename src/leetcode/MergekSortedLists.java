package leetcode;

import leetcode.model.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 * <p>
 * num:23
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author: TuGai
 * @createTime: 2020-06-21 23:47
 **/
public class MergekSortedLists {

    // ==================  用优先队列排序 牛皮啊 =============

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        ListNode vmNode = new ListNode(0);
        ListNode root = vmNode;
        while (!queue.isEmpty()) {
            ListNode listNode = queue.poll();
            root.next = new ListNode(listNode.val);
            if (listNode.next != null) {
                queue.add(listNode.next);
            }
            root = root.next;
        }
        return vmNode.next;
    }


}
