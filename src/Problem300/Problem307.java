package Problem300;

public class Problem307 {
    class NumArray {
        int size;
        int[] tree;
        int[] orig;

        public NumArray(int[] nums) {
            orig = nums;
            size = nums.length;
            tree = new int[size+1];
            for (int i = 1; i < tree.length; i++) {
                int index = i;
                while (index <= size) {
                    tree[index] += nums[i-1];
                    index += Integer.lowestOneBit(index);
                }
            }
        }

        public void update(int i, int val) {
            int diff = val - orig[i];
            orig[i] = val;
            i++;
            while (i <= size) {
                tree[i] += diff;
                i += Integer.lowestOneBit(i);
            }
        }

        public int sumRange(int i, int j) {
            int result = 0;
            j++;
            while (j > 0) {
                result += tree[j];
                j -= Integer.lowestOneBit(j);
            }
            while (i > 0) {
                result -= tree[i];
                i -= Integer.lowestOneBit(i);
            }
            return result;
        }
    }
}
