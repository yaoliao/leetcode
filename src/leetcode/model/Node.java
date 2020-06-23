package leetcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TuGai
 * @createTime: 2020-06-22 22:33
 **/
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();
        Node root = this;
        while (root != null) {
            list.add(root.val + "," + (root.random == null ? null : root.random.val));
            root = root.next;
        }
        return list.toString();
    }
}
