package Problem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Problem39 {
    private final List<List<Integer>> combinationSumOutput = new ArrayList<>();
    private final ArrayDeque<Integer> combinationSumStack = new ArrayDeque<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumGenerator(candidates, target, 0);
        return combinationSumOutput;
    }

    private void combinationSumGenerator(int[] nums, int remainder, int index) {
        if (remainder == 0) combinationSumOutput.add(new ArrayList<>(combinationSumStack));
        if (remainder < 0 || index == nums.length) return;
        for (int i = index; i < nums.length; i++) {
            int n = nums[i];
            combinationSumStack.addFirst(n);
            combinationSumGenerator(nums, remainder - n, i);
            combinationSumStack.removeFirst();
        }
    }
}
