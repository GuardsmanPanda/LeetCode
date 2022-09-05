package Problem200;

public class Problem251 {
    class Vector2D {
        private final int[][] arr;
        private int idx = 0;
        private int ndx = -1;

        public Vector2D(int[][] vec) {
            arr = vec;
            movePointer();
        }

        public int next() {
            int res = arr[idx][ndx];
            movePointer();
            return res;
        }

        private void movePointer() {
            if (idx >= arr.length) {
                return;
            }
            ndx++;
            if (ndx >= arr[idx].length) {
                idx++;
                ndx = -1;
                movePointer();
            }
        }

        public boolean hasNext() {
            return idx < arr.length;
        }
    }
}
