package Problem;

import java.util.*;

public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> output = new HashSet<>();
        if (nums.length < 3) return new ArrayList<>(output);
        Set<Integer> numbers = new HashSet<>();
        Arrays.sort(nums);
        numbers.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num1 = nums[i];
            if (i > 1 && num1 == nums[i - 1] && num1 == nums[i - 2]) continue;
            int lastNumber2 = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if (lastNumber2 == num2) continue;
                if (numbers.contains(-num1 - num2)) {
                    List<Integer> result = new ArrayList<>();
                    result.add(-num1 - num2);
                    result.add(num1);
                    result.add(num2);
                    output.add(result);
                }
                lastNumber2 = num2;
            }
            numbers.add(num1);
        }
        return new ArrayList<>(output);
    }
}
