package Problem2300;

public class Problem2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        int[] lastIdx = new int[4];
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                lastIdx[c & 0b11] = i;
            }
            ans += garbage[i].length();
        }
        for (int i = 0; i < travel.length; i++) {
            if (lastIdx[0] > i) {
                ans += travel[i];
            }
            if (lastIdx[1] > i) {
                ans += travel[i];
            }
            if (lastIdx[3] > i) {
                ans += travel[i];
            }
        }
        return ans;
    }
}
