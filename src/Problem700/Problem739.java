package Problem700;

import java.util.ArrayDeque;

public class Problem739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && stack.peekFirst()[0] <= temp)
                stack.removeFirst();
            if (stack.isEmpty()) output[i] = 0;
            else output[i] = stack.peekFirst()[1] - i;

            stack.addFirst(new int[] {temp, i});
        }
        return output;
    }
}
