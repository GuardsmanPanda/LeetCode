package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {
    List<List<Integer>> fourSumOutput = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        long[] longNums = new long[n];
        for (int i = 0; i < n; i++) {
            longNums[i] = nums[i];
        }
        Arrays.sort(longNums);
        for (int i = 0; i < n - 3; i++) {
            if (longNums[i] + longNums[n - 3] + longNums[n - 2] + longNums[n - 1] < target) continue; //skip too low i
            if (longNums[i] + longNums[i + 1] + longNums[i + 2] + longNums[i + 3] > target) break; //end too high i
            if (i == 0 || longNums[i] != longNums[i - 1]) fourSum3(i, longNums, target - longNums[i]);
        }
        return fourSumOutput;
    }

    public void fourSum3(int index, long[] nums, long target) {
        int n = nums.length;
        for (int i = index + 1; i < n - 2; i++) {
            if (nums[i] + nums[n - 2] + nums[n - 1] < target) continue; //skip too low i
            if (i == index + 1 || nums[i] != nums[i - 1]) fourSum2(index, i, nums, target - nums[i]);
        }
    }

    public void fourSum2(int index1, int index2, long[] nums, long target) {
        for (int left = index2 + 1, right = nums.length - 1; left < right; ) {
            long total = nums[left] + nums[right];
            if (total == target) {
                fourSumOutput.add(Arrays.asList((int)nums[index1], (int)nums[index2], (int)nums[left], (int)nums[right]));
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (right > left && nums[right] == nums[right - 1]) right--;
                right--;
                left++;
            } else if (total > target) {
                while (right > left && nums[right] == nums[right - 1]) right--;
                right--;
            } else {
                while (left < right && nums[left] == nums[left + 1]) left++;
                left++;
            }
        }
    }
}
