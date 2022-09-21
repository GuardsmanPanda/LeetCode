package Problem900;

import java.util.HashMap;
import java.util.TreeMap;

public class Problem981 {
    class TimeMap {
        private final HashMap<String, TreeMap<Integer, String>> valueMap = new HashMap<>();

        public void set(String key, String value, int timestamp) {
            valueMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            var treeMap = valueMap.get(key);
            if (treeMap == null) {
                return "";
            }
            var entry = treeMap.floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }
}
