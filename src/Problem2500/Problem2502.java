package Problem2500;

public class Problem2502 {
    class Allocator {
        private final int[] memory;
        public Allocator(int n) {
            memory = new int[n];
        }

        public int allocate(int size, int mID) {
            for (int i = 0; i < memory.length - size + 1; i++) {
                int len = 0;
                while (i + len < memory.length && memory[i + len] == 0) {
                    len++;
                }
                if (len >= size) {
                    for (int j = 0; j < size; j++) {
                        memory[i + j] = mID;
                    }
                    return i;
                }
                i += len;
            }
            return -1;
        }

        public int free(int mID) {
            int freed = 0;
            for (int i = 0; i < memory.length; i++) {
                if (memory[i] == mID) {
                    memory[i] = 0;
                    freed++;
                }
            }
            return freed;
        }
    }
}
