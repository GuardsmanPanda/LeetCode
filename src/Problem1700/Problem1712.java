package Problem1700;

public class Problem1712 {
    public int waysToSplit(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int res = 0;
        for (int i = 0, jLeft = 0, jRight = 0; i < nums.length; i++) {
            while (jLeft < nums.length && (jLeft <= i || prefix[i]*2 > prefix[jLeft])) {
                jLeft++;
            }
            // total = prefix[prefix.length - 1] - prefix[jRight];
            // k = prefix[jRight] - prefix[i];
            while (jRight < nums.length && (jRight < jLeft || prefix[jRight] - prefix[i] <= prefix[prefix.length - 1] - prefix[jRight])) {
                jRight++;
            }
            System.out.println("i: " + i + " jLeft: " + jLeft + " jRight: " + jRight);
            if (prefix[prefix.length - 1] - prefix[jRight - 1] < prefix[jRight - 1] - prefix[i]) {
                break;
            }
            res += jRight - jLeft;
            res %= 1000000007;
        }
        return res;
    }
}
