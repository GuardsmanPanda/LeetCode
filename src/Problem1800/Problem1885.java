package Problem1800;

import java.util.Arrays;

public class Problem1885 {
    public long countPairs(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        long res = 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] > 0) {
                res += right - left;
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

}
