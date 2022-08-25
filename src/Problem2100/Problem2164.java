package Problem2100;

public class Problem2164 {
    public int[] sortEvenOdd(int[] nums) {
        int[] evenCount = new int[101];
        int[] oddCount = new int[101];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenCount[nums[i]]++;
            } else {
                oddCount[nums[i]]++;
            }
        }
        int[] output = new int[nums.length];
        int edx = 0, odx = 100;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                while (evenCount[edx] == 0) {
                    edx++;
                }
                --evenCount[edx];
                output[i] = edx;
            } else {
                while (oddCount[odx] == 0) {
                    odx--;
                }
                --oddCount[odx];
                output[i] = odx;
            }
        }
        return output;
    }
}
