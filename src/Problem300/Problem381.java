package Problem300;

import java.util.*;

public class Problem381 {
    class RandomizedCollection {
        private Random rd;
        private List<Integer> list;
        private Map<Integer, Set<Integer>> indexMap;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            indexMap = new HashMap<>();
            list = new ArrayList<>();
            rd = new Random();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean result = !indexMap.containsKey(val);

            indexMap.computeIfAbsent(val, k -> new HashSet<>()).add(list.size());
            list.add(val);

            return result;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!indexMap.containsKey(val)) {
                return false;
            }

            int last = list.remove(list.size() - 1);
            Set<Integer> indexSet = indexMap.get(val);
            int index = indexSet.iterator().next();
            if (indexSet.size() == 1) {
                indexMap.remove(val);
            } else {
                indexSet.remove(index);
            }

            if (index != list.size()) {
                list.set(index, last);
                Set<Integer> lastIndex = indexMap.get(last);
                lastIndex.remove(list.size());
                lastIndex.add(index);
            }

            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return list.get(rd.nextInt(list.size()));
        }
    }
}
