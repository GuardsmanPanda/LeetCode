package Problem1100;

public class Problem1183 {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        if (width < height) {
            int temp = width;
            width = height;
            height = temp;
        }
    }
}
