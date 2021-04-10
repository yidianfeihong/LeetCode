package solutions;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution146 {
    /**
     * ["LRUCache","get","put","get","put","put","get","get"]
     * [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
     */
    static LRUCache lRUCache;

    public static void main(String[] args) {
        lRUCache = new LRUCache(2);
        lRUCache.get(2);
        lRUCache.put(2, 6);
        lRUCache.get(1);
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        lRUCache.get(1);
        lRUCache.get(2);
        print();
    }

    public static void print() {
        for (Map.Entry<Integer, Integer> entry : lRUCache.map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }


    static class LRUCache {
        public int capacity;
        public LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new LinkedHashMap<>(capacity, 0.75f, true);
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            return map.get(key);
        }

        public void put(int key, int value) {
            if (!map.containsKey(key) && map.size() == capacity) {
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                if (iterator.hasNext()) {
                    Integer headKey = iterator.next().getKey();
                    map.remove(headKey);
                }
            }
            map.put(key, value);
        }
    }
}
