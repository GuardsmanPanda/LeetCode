package Special;

import java.util.*;

public class AllOne {
    private final HashMap<String, Integer> wordCount = new HashMap<>();
    private final TreeMap<Integer, LinkedHashSet<String>> map = new TreeMap<>();

    public void inc(String key) {
        Integer old = wordCount.get(key);
        if (old == null) {
            wordCount.put(key, 1);
            map.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        } else {
            wordCount.put(key, old + 1);
            map.computeIfAbsent(old + 1, k -> new LinkedHashSet<>()).add(key);
            map.compute(old, (k, v) -> {
                if (v == null || v.size() == 1) {
                    return null;
                }
                v.remove(key);
                return v;
            });
        }
    }

    public void dec(String key) {
        Integer old = wordCount.get(key);
        map.compute(old, (k, v) -> {
            if (v == null || v.size() == 1) {
                return null;
            }
            v.remove(key);
            return v;
        });
        if (old == 1) {
            wordCount.remove(key);
        } else {
            wordCount.put(key, old - 1);
            map.computeIfAbsent(old - 1, k -> new LinkedHashSet<>()).add(key);
        }
    }

    public String getMaxKey() {
        if (map.isEmpty()) {
            return "";
        }
        return map.lastEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        if (map.isEmpty()) {
            return "";
        }
        return map.firstEntry().getValue().iterator().next();
    }
}
