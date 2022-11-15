package Problem;

public class Problem11 {
    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int ln = height[left], rn = height[right];
            if (ln < rn) {
                maxArea = Math.max(maxArea, ln * (right - left));
                while (left < right && height[left] <= ln) {
                    left++;
                }
            } else {
                maxArea = Math.max(maxArea, rn * (right - left));
                while (left < right && height[right] <= rn) {
                    right--;
                }
            }
        }
        return maxArea;
    }
}
