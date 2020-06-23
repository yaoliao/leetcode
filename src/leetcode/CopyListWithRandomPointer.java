package leetcode;

import leetcode.model.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * <p>
 * num:138
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * @author: TuGai
 * @createTime: 2020-06-22 22:32
 **/
public class CopyListWithRandomPointer {

    // ================== 利用 map ==================
    public Node copyRandomListV1(Node head) {
        if (head == null) return null;

        Map<Node, Node> nodeNodeMap = new HashMap<>();
        Node root = head;
        while (root != null) {
            nodeNodeMap.put(root, new Node(root.val));
            root = root.next;
        }

        root = head;
        while (root != null) {
            nodeNodeMap.get(root).next = nodeNodeMap.get(root.next);
            nodeNodeMap.get(root).random = nodeNodeMap.get(root.random);
            root = root.next;
        }
        return nodeNodeMap.get(head);
    }

    // =================== 在原节点后面添加相同节点 空间复杂度 O(1) ===================

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 为每个节点在后面复制一个自己的节点
        // 1-2-3-4  -->  1-1-2-2-3-3-4-4
        Node root = head;
        while (root != null) {
            Node newNode = new Node(root.val);
            newNode.next = root.next;
            root.next = newNode;
            root = newNode.next;
        }

        // 为每个复制节点的 random 节点赋值
        root = head;
        while (root != null) {
            root.next.random = root.random != null ? root.random.next : null;
            root = root.next.next;
        }

        // 分裂出来复制的节点
        Node oldNode = head;
        Node vmNode = new Node(0);
        Node vmHead = vmNode;
        while (oldNode != null) {
            vmNode.next = oldNode.next;
            vmNode = vmNode.next;
            oldNode = oldNode.next.next;
        }
        return vmHead.next;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1.random = node3;
        node4.random = node1;

        CopyListWithRandomPointer pointer = new CopyListWithRandomPointer();
        Node node = pointer.copyRandomList(node1);
        System.out.println(node);
    }

}
