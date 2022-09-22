package Problem2100;

public class Problem2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0, a = 0, b = plants.length - 1;
        int ca = capacityA, cb = capacityB;
        while (a < b) {
            if (ca < plants[a]) {
                ca = capacityA;
                res++;
            }
            if (cb < plants[b]) {
                cb = capacityB;
                res++;
            }
            ca -= plants[a++];
            cb -= plants[b--];
        }
        return res + (a == b && Math.max(ca, cb) < plants[a] ? 1 : 0);
    }
}
