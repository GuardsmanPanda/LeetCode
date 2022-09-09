package Problem1300;

import java.util.ArrayList;
import java.util.List;

public class Problem1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            tmp.add(index[i], nums[i]);
        }
        return tmp.stream().mapToInt(i -> i).toArray();
    }
}
