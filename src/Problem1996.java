import java.util.Arrays;

public class Problem1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int count = 0;
        int maxDef = 0;
        for (int[] prop : properties) {
            if (prop[1] < maxDef) {
                count++;
            } else {
                maxDef = prop[1];
            }
        }
        return count;
    }
}
