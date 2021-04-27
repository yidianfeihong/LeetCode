package solutions;

import java.util.HashMap;
import java.util.Map;

public class Lru {

    int size;
    int capacity;
    Dnode head;
    Dnode tail;
    Map<Integer, Dnode> cache;

    public class Dnode {
        int key;
        int val;
        Dnode pre;
        Dnode next;

        public Dnode() {
        }

        public Dnode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Lru(int capacity) {
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
            node.val = value;
            moveToHead(node);
        } else {
            Dnode newNode = new Dnode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                Dnode removeNode = removeTail();
                cache.remove(removeNode.key);
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
            return node.val;
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

    private Dnode removeTail() {
        Dnode node = tail.pre;
        removeNode(node);
        return node;
    }
}
