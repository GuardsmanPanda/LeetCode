package Problem100;

public class Problem153 {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low<high) {
            int mid = (high-low)/2 + low;
            if (nums[mid] < nums[high]) high = mid;
            else low = mid+1;
        }
        return nums[low];
    }
}
