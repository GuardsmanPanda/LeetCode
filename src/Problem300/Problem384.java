package Problem300;

import java.util.Arrays;
import java.util.Random;

public class Problem384 {
    static class Solution {
        private final int[] orig;
        private final int[] arr;
        Random random = new Random();
        public Solution(int[] nums) {
            arr = Arrays.copyOf(nums, nums.length);
            orig = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return orig;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for (int i = arr.length - 1; i > 0; i--) {
                int index = random.nextInt(i+1);
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
            return arr;
        }
    }
}
