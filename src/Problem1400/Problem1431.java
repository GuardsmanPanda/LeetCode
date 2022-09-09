package Problem1400;

import java.util.Arrays;
import java.util.List;

public class Problem1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().orElse(0);
        return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= max).toList();
    }
}
