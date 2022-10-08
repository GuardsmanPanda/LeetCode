package Problem1200;

import java.util.ArrayList;
import java.util.List;

public class Problem1286 {
    class CombinationIterator {
        private final List<String> combinations = new ArrayList<>();
        int cur = 0;

        public CombinationIterator(String characters, int combinationLength) {
            int val = 0;
            while (Integer.bitCount(val) != combinationLength) {
                val++;
            }
            while (val < (1 << characters.length())) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < characters.length(); i++) {
                    if ((val & (1 << i)) != 0) {
                        sb.append(characters.charAt(i));
                    }
                }
                combinations.add(sb.toString());
                val++;
                while (Integer.bitCount(val) != combinationLength) {
                    val++;
                }
            }
            combinations.sort(String::compareTo);
        }

        public String next() {
            return combinations.get(cur++);
        }

        public boolean hasNext() {
            return cur < combinations.size();
        }
    }
}
