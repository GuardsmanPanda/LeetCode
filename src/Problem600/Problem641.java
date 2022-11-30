package Problem600;

public class Problem641 {
    class MyCircularDeque {
        int[] values;
        int head = 0, tail = 1, size = 0, cap;

        public MyCircularDeque(int k) {
            values = new int[k];
            cap = k;
        }

        public boolean insertFront(int value) {
            if (size == cap) return false;
            values[head = ++head % cap] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (size == cap) return false;
            values[tail = (tail - 1 + cap) % cap] = value;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (size == 0) return false;
            head = (head - 1 + cap) % cap;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (size == 0) return false;
            tail = ++tail % cap;
            size--;
            return true;
        }

        public int getFront() {
            return size == 0 ? -1 : values[head];
        }
        public int getRear() {
            return size == 0 ? -1 : values[tail];
        }
        public boolean isEmpty() {
            return size == 0;
        }
        public boolean isFull() {
            return size == cap;
        }
    }
}
