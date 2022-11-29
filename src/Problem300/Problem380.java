package Problem300;

import java.util.*;

public class Problem380 {
    class RandomizedSet {
        private final Map<Integer, Integer> keyPosition = new HashMap<>();
        private final List<Integer> keyList = new ArrayList<>();
        private final Random random = new Random();

        public boolean insert(int val) {
            if (keyPosition.containsKey(val)) return false;
            keyPosition.put(val, keyList.size());
            keyList.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!keyPosition.containsKey(val)) return false;
            Integer pos = keyPosition.remove(val);
            Integer endVal = keyList.remove(keyList.size()-1);
            if (pos < keyList.size()) {
                keyList.set(pos,endVal);
                keyPosition.put(endVal, pos);
            }
            return true;
        }

        public int getRandom() {
            return keyList.get(random.nextInt(keyList.size()));
        }
    }

}
