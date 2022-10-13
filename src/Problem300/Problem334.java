package Problem300;

public class Problem334 {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) min = num;
            else if(num <= second) second = num;
            else if (num > second) return true;
        }
        return false;
    }
}
