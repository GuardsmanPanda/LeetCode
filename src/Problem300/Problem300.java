package Problem300;

public class Problem300 {
    public int lengthOfLIS(int[] nums) {
        int[] data = new int[10_000];
        int size = 0;
        for (int n : nums) { // <- O(n)
            int low = 0, high = size;
            while (low < high) { // O(log2(n))
                int mid = (high-low)/2 + low;
                if (data[mid] < n) low = mid+1;
                else high = mid;
            }
            data[low < size ? low : size++] = n;
        }
        return size;
    }
}
