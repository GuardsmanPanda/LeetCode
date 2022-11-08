package Problem1800;

import java.util.ArrayList;
import java.util.List;

public class Problem1868 {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        while (idx1 < encoded1.length && idx2 < encoded2.length) {
            int[] e1 = encoded1[idx1];
            int[] e2 = encoded2[idx2];
            int val = e1[0] * e2[0];
            int freq = Math.min(e1[1], e2[1]);
            if (e1[1] < e2[1]) {
                e2[1] -= e1[1];
                idx1++;
            } else {
                e1[1] -= e2[1];
                idx2++;
            }
            if (freq == 0) {
                continue;
            }
            if (res.size() > 0 && res.get(res.size() - 1).get(0) == val) {
                res.get(res.size() - 1).set(1, res.get(res.size() - 1).get(1) + freq);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(val);
                tmp.add(freq);
                res.add(tmp);
            }
        }
        return res;
    }
}
