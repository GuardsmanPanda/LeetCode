package Problem400;

import java.util.ArrayList;
import java.util.List;

public class Problem448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int number = Math.abs(nums[i]);
            nums[number-1] = -Math.abs(nums[number-1]);
        }
        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) returnList.add(i+1);
        }
        return returnList;
    }
}
