package leetcode;

import leetcode.model.ListNode;

/**
 * 237. 删除链表中的节点
 * <p>
 * num:237
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author: TuGai
 * @createTime: 2020-06-24 22:51
 **/
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


}
