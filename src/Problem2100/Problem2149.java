package Problem2100;

public class Problem2149 {
    public int[] rearrangeArray(int[] nums) {
        int[] aux = new int[nums.length];
        int left = 0, right = 1;
        for (int num : nums) {
            if (num > 0) {
                aux[left] = num;
                left += 2;
            } else {
                aux[right] = num;
                right += 2;
            }
        }
        return aux;
    }
}
