package Problem200;

import java.util.ArrayDeque;

public class Problem239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] output = new int[nums.length - k + 1];
        int outIndex = 0;
        for (int i = 0; i < k; i++) {
            int val = nums[i];
            while (!queue.isEmpty() && val >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        output[outIndex++] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            int val = nums[i];
            if (queue.peekFirst() == i - k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && val >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            output[outIndex++] = nums[queue.peekFirst()];
        }
        return output;
    }
}
