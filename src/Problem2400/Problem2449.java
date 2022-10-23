package Problem2400;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem2449 {
    public long makeSimilar(int[] nums, int[] target) {
        var even1 = Arrays.stream(nums).filter(i -> i % 2 == 0).sorted().toArray();
        var odd1 = Arrays.stream(nums).filter(i -> i % 2 == 1).sorted().toArray();
        var even2 = Arrays.stream(target).filter(i -> i % 2 == 0).sorted().toArray();
        var odd2 = Arrays.stream(target).filter(i -> i % 2 == 1).sorted().toArray();
        var sum = IntStream.range(0, even1.length).map(i -> Math.abs(even1[i] - even2[i])).mapToLong(i -> i).sum();
        sum += IntStream.range(0, odd1.length).map(i -> Math.abs(odd1[i] - odd2[i])).mapToLong(i -> i).sum();
        return sum / 4;
    }
}
