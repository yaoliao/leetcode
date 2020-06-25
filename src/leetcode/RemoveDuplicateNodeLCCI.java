package leetcode;

import leetcode.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 * <p>
 * num:02.01
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 *
 * @author: TuGai
 * @createTime: 2020-06-26 00:09
 **/
public class RemoveDuplicateNodeLCCI {

    public ListNode removeDuplicateNodesV1(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode vmNode = new ListNode(0);
        ListNode root = vmNode;
        while (head != null) {
            if (!set.contains(head.val)) {
                vmNode.next = head;
                vmNode = vmNode.next;
                set.add(head.val);
            } else {
                vmNode.next = null;
            }
            head = head.next;
        }
        return root.next;
    }

    // ============================
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> occurred = new HashSet<>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next(new ListNode(2))
                .next(new ListNode(3))
                .next(new ListNode(2))
                .next(new ListNode(1));

        RemoveDuplicateNodeLCCI lcci = new RemoveDuplicateNodeLCCI();
        System.out.println(lcci.removeDuplicateNodes(root));
    }
}
