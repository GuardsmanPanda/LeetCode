package Problem1100;

public class Problem1011 {
    public int shipWithinDays(int[] weights, int D) {
        int low = 0, high = 25_000_000;
        while (low < high) {
            int mid = (high-low)/2 + low;
            if (canShip(weights, D, mid)) high = mid;
            else low = mid+1;
        }
        return low;
    }

    private boolean canShip(int[] w, int ships, int maxW) {
        int cur = 0;
        for (int i : w) {
            if (i > maxW) return false;
            if (cur + i > maxW) {
                ships--;
                cur = 0;
            }
            cur += i;
        }
        return ships > 0;
    }
}
