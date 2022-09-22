package Problem1700;

public class Problem1769 {
    public int[] minOperations(String boxes) {
        int rightCount = 0;
        int leftCount = 0;
        int rightSum = 0;
        int leftSum = 0;
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                rightSum += i;
                rightCount++;
            }
        }
        int[] result = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            result[i] = leftSum + rightSum;
            if (boxes.charAt(i) == '1') {
                rightCount--;
                leftCount++;
            }
            rightSum -= rightCount;
            leftSum += leftCount;
        }
        return result;
    }
}
