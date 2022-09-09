package Problem1600;

import java.util.ArrayList;
import java.util.List;

public class Problem1656 {
    class OrderedStream {
        private final String[] stream;
        private int ptr = 1;

        public OrderedStream(int n) {
            stream = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            List<String> result = new ArrayList<>();
            stream[idKey] = value;
            while (ptr < stream.length && stream[ptr] != null) {
                result.add(stream[ptr++]);
            }
            return result;
        }
    }
}
