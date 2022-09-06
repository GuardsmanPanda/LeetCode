package Problem;

public class Problem42 {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int sum = 0, lastHeight = 0, lastIndex = -1, currentWater = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= lastHeight) {
                lastHeight = height[i];
                sum += currentWater;
                currentWater = 0;
                lastIndex = i;
            }
            else currentWater += lastHeight - height[i];
        }
        currentWater = 0;
        lastHeight = 0;
        for (int i = height.length-1; i >= lastIndex; i--) {
            if (height[i] >= lastHeight) {
                lastHeight = height[i];
                sum += currentWater;
                currentWater = 0;
            }
            else currentWater += lastHeight - height[i];
        }
        return sum;
    }
}
