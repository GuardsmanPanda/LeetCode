package Problem600;

public class Problem622 {
    class MyCircularQueue {
        int[] values;
        int head = 0, tail = 1, size = 0, cap;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            if (k == 1) tail = 0;
            cap = k;
            values = new int[k];
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (size == cap) return false;
            values[head = (head + 1) % cap] = value;
            size++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (size == 0) return false;
            tail = (tail + 1) % cap;
            size--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            return size == 0 ? -1 : values[tail];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            return size == 0 ? -1 : values[head];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == cap;
        }
    }
}
