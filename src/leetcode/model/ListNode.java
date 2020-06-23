package leetcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TuGai
 * @createTime: 2020-06-21 22:28
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode next(ListNode next) {
        this.next = next;
        return next;
    }

    public static ListNode getListNode() {
        ListNode root = new ListNode(1);
        root.next(new ListNode(2))
                .next(new ListNode(4))
                .next(new ListNode(7))
                .next(new ListNode(9));
        return root;
    }


    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        ListNode root = this;
        while (root != null) {
            list.add(root.val);
            root = root.next;
        }
        return list.toString();
    }
}
