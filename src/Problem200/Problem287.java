package Problem200;

public class Problem287 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0; fast = nums[fast];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
