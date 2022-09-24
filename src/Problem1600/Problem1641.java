package Problem1600;

public class Problem1641 {
    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int k = 1; k < n; k++) {
            u = u + o + i + e + a;
            o = o + i + e + a;
            i = i + e + a;
            e = e + a;
        }
        return a + e + i + o + u;
    }
}
