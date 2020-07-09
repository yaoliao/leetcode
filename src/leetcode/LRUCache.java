package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: TuGai
 * @createTime: 2020-07-04 20:49
 **/
public class LRUCache {

    private final int capacity;
    private int size;

    private final Node root;
    private final Node tail;

    private final Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.root = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.root.next = tail;
        this.tail.pre = root;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // move to head
        Node node = map.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (size >= capacity && !map.containsKey(key)) {
            Node node = tail.pre;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            map.remove(node.key);
            size--;
        }
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            map.put(key, node);
            // append to head
            Node next = root.next;
            root.next = node;
            node.pre = root;
            next.pre = node;
            node.next = next;
            size++;
        } else {
            Node node = map.get(key);
            if (node.val != value) {
                node.val = value;
            }
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        node.pre.next = node.next;
        if (node.next != null) node.next.pre = node.pre;

        Node headNext = root.next;
        root.next = node;
        node.pre = root;
        node.next = headNext;
        if (headNext != null) headNext.pre = node;
    }

    class Node {
        public int key;
        public int val;
        public Node pre;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1 /* 缓存容量 */);
        cache.put(2, 1);
        cache.get(2);
        cache.put(3, 2);
        cache.get(2);
        cache.get(3);

        LRUCache map = new LRUCache(2 /* 缓存容量 */);
        map.put(2, 1);
        map.put(2, 2);
        map.get(2);

       /* ["LRUCache","put","get","put","get","get"]
            [[1],[2,1],[2],[3,2],[2],[3]]*/

    }
}
