package Problem200;

import java.util.List;

public class Problem281 {
    public class ZigzagIterator {
        private final List<Integer> v1;
        private final List<Integer> v2;
        private boolean v1Turn = true;
        private int index1 = 0;
        private int index2 = 0;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public int next() {
            if (index1 == v1.size() || (index2 < v2.size() && !v1Turn)) {
                v1Turn = !v1Turn;
                return v2.get(index2++);
            }
            v1Turn = !v1Turn;
            return v1.get(index1++);
        }

        public boolean hasNext() {
            return index1 < v1.size() || index2 < v2.size();
        }
    }
}
