package Problem400;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Problem460 {
    class LFUCache {
        private class CacheVal{
            public int value;
            public int usage = 1;
            public CacheVal(int v) {
                value = v;
            }
        }
        private final Map<Integer, LinkedHashSet<Integer>> leastUsed = new HashMap<>();
        private final Map<Integer, CacheVal> cache;
        private final int cap;
        private int min = 0;
        public LFUCache(int capacity) {
            cache = new HashMap<>(capacity);
            cap = capacity;
        }

        public int get(int key) {
            CacheVal item = cache.get(key);
            if (item == null) {
                return -1;
            }
            LinkedHashSet<Integer> set = leastUsed.get(item.usage);
            set.remove(key);
            if (set.size() == 0 && min == item.usage) {
                min++;
            }
            item.usage++;
            leastUsed.computeIfAbsent(item.usage, k -> new LinkedHashSet<>()).add(key);
            return item.value;
        }

        public void put(int key, int value) {
            if (cap == 0) {
                return;
            }
            if (get(key) != -1) {
                cache.get(key).value = value;
                return;
            }
            if (cache.size() == cap) {
                LinkedHashSet<Integer> set = leastUsed.get(min);
                int k = set.iterator().next();
                set.remove(k);
                cache.remove(k);
            }
            CacheVal item = new CacheVal(value);
            cache.put(key, item);
            leastUsed.computeIfAbsent(item.usage, k -> new LinkedHashSet<>()).add(key);
            min = 1;
        }
    }
}
