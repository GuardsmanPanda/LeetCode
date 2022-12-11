package Problem;

public class Problem31 {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                int value = nums[i];
                reverseArr(nums, i+1);
                for (int k = i+1; k < nums.length; k++) {
                    if (nums[k] > value) {
                        nums[i] = nums[k];
                        nums[k] = value;
                        return;
                    }
                }
            }
        }
        reverseArr(nums, 0);
    }
    private void reverseArr(int[] arr, int from) {
        int left = from, right = arr.length-1;
        while(left<right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++; right--;
        }
    }
}
