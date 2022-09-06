package Problem;

public class Problem84 {
    public int largestRectangleArea(int[] heights) {
        int[] stack = new int[heights.length];
        int[] leftLess = new int[heights.length];
        int stackIndex = -1;
        for (int i = 0; i < heights.length; i++) {
            while (stackIndex >= 0 && heights[stack[stackIndex]] >= heights[i])
                stackIndex--;
            leftLess[i] = stackIndex == -1 ? -1 : stack[stackIndex];
            stack[++stackIndex] = i;
        }
        int maxArea = 0;
        stackIndex = -1;
        for (int i = heights.length - 1; i >= 0; i--) {
            while (stackIndex >= 0 && heights[stack[stackIndex]] >= heights[i])
                stackIndex--;
            int length = stackIndex == -1 ? heights.length-i-1 : stack[stackIndex]-i-1;
            length += i - leftLess[i];
            maxArea = Math.max(maxArea, heights[i]*length);
            stack[++stackIndex] = i;
        }
        return maxArea;
    }
}
