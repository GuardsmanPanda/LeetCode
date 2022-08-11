package Problem1800;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem1823 {
    public int findTheWinner(int n, int k) {
        List<Integer> numbers = IntStream.range(1, n+1).boxed().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        int pos = 0;
        while (numbers.size() > 1) {
            pos = (pos + k - 1) % numbers.size();
            numbers.remove(pos);
        }
        return numbers.get(0);
    }
}
