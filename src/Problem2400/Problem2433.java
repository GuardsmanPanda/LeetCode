package Problem2400;

public class Problem2433 {
    public int[] findArray(int[] pref) {
        int last = pref[0];
        for (int i = 1; i < pref.length; i++) {
            int next = pref[i];
            pref[i] = last ^ next;
            last = next;
        }
        return pref;
    }
}
