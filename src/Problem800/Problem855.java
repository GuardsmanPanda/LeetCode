package Problem800;

import java.util.ArrayList;
import java.util.List;

public class Problem855 {
    class ExamRoom {
        private final int max;
        List<Integer> used = new ArrayList<>();
        public ExamRoom(int N) {
            max = N-1;
        }

        public int seat() {
            if (used.size() == 0) {
                used.add(0);
                return 0;
            }
            int idx = 0, size = used.get(0), pos = 0;
            for (int i = 0; i < used.size()-1; i++) {
                int offset = (used.get(i+1) - used.get(i))/2;
                if (offset > size) {
                    pos = used.get(i)+offset;
                    size = offset;
                    idx = i+1;
                }
            }
            if (max-used.get(used.size()-1) > size) {
                idx = used.size();
                pos = max;
            }
            used.add(idx, pos);
            return pos;
        }

        public void leave(int p) {
            used.remove(new Integer(p));
        }
    }

}
