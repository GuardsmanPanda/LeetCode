package Problem2000;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Problem2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] count = new int[101];
        Arrays.stream(nums1).distinct().forEach(i -> count[i]++);
        Arrays.stream(nums2).distinct().forEach(i -> count[i]++);
        Arrays.stream(nums3).distinct().forEach(i -> count[i]++);
        return IntStream.range(1, 101).filter(i -> count[i] >= 2).boxed().toList();

    }
}
