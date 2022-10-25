package Problem2300;

import java.util.Arrays;

public class Problem2340 {
    public int minimumSwaps(int[] nums) {
        int min = Arrays.stream(nums).min().orElse(0);
        int max = Arrays.stream(nums).max().orElse(0);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min) {
                while (i != 0) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    res++;
                    i--;
                }
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == max) {
                while (i != nums.length - 1) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    res++;
                    i++;
                }
                break;
            }
        }
        return res;
    }
}
