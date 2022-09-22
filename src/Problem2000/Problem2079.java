package Problem2000;

public class Problem2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int res = plants.length, cur = capacity;
        for (int i = 0; i < plants.length; i++) {
            int n = plants[i];
            if (cur < n) {
                cur = capacity;
                res += i * 2;
            }
            cur -= n;
        }
        return res;
    }
}
