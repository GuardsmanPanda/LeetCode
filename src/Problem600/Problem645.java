package Problem600;

public class Problem645 {
    public int[] findErrorNums(int[] nums) {
        boolean[] isThere = new boolean[nums.length+1];
        int duplicate = 0;
        for (int i : nums) {
            if (isThere[i]) duplicate = i;
            else isThere[i] = true;
        }
        int missing = 0;
        for (int i = 1; i < isThere.length; i++) {
            if (!isThere[i]) {
                missing = i; break;
            }
        }
        return new int[] {duplicate, missing};
    }
}
