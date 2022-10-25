package Problem1400;

import java.util.ArrayList;
import java.util.List;

public class Problem1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int cur = 1;
        for (int i : target) {
            while (cur++ < i) {
                res.add("Push");
                res.add("Pop");
            }
            res.add("Push");
        }
        return res;
    }
}
