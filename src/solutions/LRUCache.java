package solutions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int size;
    private int capacity;
    private PairNode head;
    private PairNode tail;

    Map<Integer, PairNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new PairNode();
        tail = new PairNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        PairNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    private void moveToHead(PairNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(PairNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(PairNode node) {
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
    }

    public void put(int key, int value) {
        PairNode node = cache.get(key);
        if (cache.containsKey(key)) {
            node.value = value;
            moveToHead(node);
        } else {
            PairNode newNode = new PairNode(key, value);
            cache.put(key, newNode);
            size++;
            if (size > capacity) {
                PairNode res = removeTail();
                cache.remove(res.key);
                size--;
            }
        }
    }

    public PairNode removeTail() {
        PairNode node = this.tail.pre;
        removeNode(node);
        return node;
    }

    static class PairNode {
        int key;
        int value;

        PairNode pre;
        PairNode next;

        public PairNode() {
        }

        public PairNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}