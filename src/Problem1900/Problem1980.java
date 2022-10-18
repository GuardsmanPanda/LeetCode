package Problem1900;

import java.util.Arrays;

public class Problem1980 {
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != Integer.parseInt(nums[i], 2)) {
                StringBuilder res = new StringBuilder(Integer.toBinaryString(i));
                while (res.length() < nums[i].length()) {
                    res.insert(0, "0");
                }
                return res.toString();
            }
        }
        StringBuilder res = new StringBuilder(Integer.toBinaryString(nums.length));
        while (res.length() < nums[0].length()) {
            res.insert(0, "0");
        }
        return res.toString();
    }
}
