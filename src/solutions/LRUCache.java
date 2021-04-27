package solutions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int size;
    private int capacity;
    private Dnode head;
    private Dnode tail;
    Map<Integer, Dnode> cache;

    static class Dnode {
        int key;
        int value;

        Dnode pre;
        Dnode next;

        public Dnode() {
        }

        public Dnode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Dnode();
        tail = new Dnode();
        head.next = tail;
        tail.pre = head;
        cache = new HashMap<>();
    }

    public void put(int key, int value) {
        Dnode node = cache.get(key);
        if (cache.containsKey(key)) {
            node.value = value;
            moveToHead(node);
        } else {
            Dnode newNode = new Dnode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                Dnode res = removeTail();
                cache.remove(res.key);
                size--;
            }
        }
    }

    public int get(int key) {
        Dnode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    private void moveToHead(Dnode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Dnode node) {
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void removeNode(Dnode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public Dnode removeTail() {
        Dnode node = tail.pre;
        removeNode(node);
        return node;
    }

}