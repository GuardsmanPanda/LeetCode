package Problem2400;

import java.util.*;

public class Problem2454 {
    public int[] secondGreaterElement(int[] nums) {
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        TreeMap<Integer, List<Integer>> stack2 = new TreeMap<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            while (stack2.size() > 0 && stack2.firstEntry().getKey() < nums[i]) {
                for (Integer integer : stack2.pollFirstEntry().getValue()) {
                    res[integer] = nums[i];
                }
            }
            while (stack1.size() > 0 && nums[stack1.peekFirst()] < nums[i]) {
                int idx = stack1.removeFirst();
                stack2.computeIfAbsent(nums[idx], k -> new ArrayList<>()).add(idx);
            }
            stack1.addFirst(i);
        }
        return res;
    }
}
