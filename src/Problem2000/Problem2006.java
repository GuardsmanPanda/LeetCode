package Problem2000;

public class Problem2006 {
    public int countKDifference(int[] nums, int k) {
        int[] count = new int[301];
        int ans = 0;
        for (int num : nums) {
            ans += count[num - k + 100];
            ans += count[num + k + 100];
            count[num + 100]++;
        }
        return ans;
    }
}
