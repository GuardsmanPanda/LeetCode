import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem254 {
    public List<List<Integer>> getFactors(int n) {
        if (n < 2) {
            return new ArrayList<>();
        }
        return getPrimeFactors(2, n, new ArrayDeque<>(), new ArrayList<>());
    }

    private List<List<Integer>> getPrimeFactors(int from, int target, ArrayDeque<Integer> stack, List<List<Integer>> result) {
        if (stack.size() > 0) {
            var tmp = new ArrayList<>(stack);
            tmp.add(target);
            result.add(tmp);
        }
        for (int i = from; i*i <= target; i++) {
            if (target % i == 0) {
                stack.addFirst(i);
                getPrimeFactors(i, target / i, stack, result);
                stack.removeFirst();
            }
        }
        return result;
    }
}
