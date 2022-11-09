package Problem1200;

import Types.CustomFunction;

import java.util.ArrayList;
import java.util.List;

public class Problem1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int a = 1, b = 1;
        while (customfunction.f(a, b) < z) {
            a++;
        }
        List<List<Integer>> result = new ArrayList<>();
        while (a > 0) {
            int val = customfunction.f(a, b);
            if (val == z) {
                result.add(List.of(a, b));
                a--;
                b++;
            } else if (val > z) {
                a--;
            } else {
                b++;
            }
        }
        return result;
    }
}
