package Problem600;

import java.util.Arrays;
import java.util.List;

public class Problem6358 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int[][] save = new int[special.size()][special.get(0).size()];
        int[] na = new int[needs.size()];
        int total = 0;
        for (int i = 0; i < needs.size(); i++) {
            total += needs.get(i) * price.get(i);
            na[i] = needs.get(i);
        }
        for (int i = 0; i < special.size(); i++) {
            List<Integer> spec = special.get(i);
            int tot = 0;
            for (int j = 0; j < na.length; j++) {
                save[i][j] = spec.get(j);
                tot += spec.get(j) * price.get(j);
            }
            save[i][na.length] = tot - spec.get(na.length);
        }
        System.out.println(Arrays.deepToString(save));
        return total - getSavings(0, save, na);
    }

    public int getSavings(int idx, int[][] save, int[] needs) {
        if (idx == save.length) {
            return 0;
        }
        int res = 0;
        int[] old = new int[needs.length];
        System.arraycopy(needs, 0, old, 0, needs.length);
        int[] cur = save[idx];
        int saved = 0;
        outer:
        while (true) {
            res = Math.max(res, saved + getSavings(idx + 1, save, needs));
            saved += cur[cur.length - 1];
            for (int i = 0; i < needs.length; i++) {
                if (needs[i] < cur[i]) {
                    break outer;
                }
                needs[i] -= cur[i];
            }
        }
        System.arraycopy(old, 0, needs, 0, needs.length);
        System.out.println("idx: " + idx + " res: " + res);
        return res;
    }
}
