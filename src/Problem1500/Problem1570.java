package Problem1500;

public class Problem1570 {
    class SparseVector {

        private int[] nums;

        SparseVector(int[] nums) {
            this.nums = nums;
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res += nums[i] * vec.nums[i];
            }
            return res;
        }
    }
}
