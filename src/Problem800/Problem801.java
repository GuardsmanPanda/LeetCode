package Problem800;

import java.util.Arrays;

public class Problem801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int[] notSwapped = new int[nums1.length];
        int[] swapped = new int[nums1.length];
        notSwapped[0] = 0;
        swapped[0] = 1;
        for (int i = 1; i < nums1.length; i++) {
            boolean swap1 = nums1[i] < nums1[i - 1] || nums2[i] < nums2[i - 1];
            boolean swap2 = nums1[i] < nums2[i - 1] || nums2[i] < nums1[i - 1];
            System.out.println("i=" + i + ", swap1=" + swap1 + ", swap2=" + swap2);
            if (swap1) {
                notSwapped[i] = swapped[i - 1];
                swapped[i] = notSwapped[i - 1] + 1;
            } else if (swap2) {
                notSwapped[i] = notSwapped[i - 1];
                swapped[i] = swapped[i - 1] + 1;
             } else {
                notSwapped[i] =  Math.min(swapped[i - 1], notSwapped[i - 1]);
                swapped[i] = 1 + Math.min(swapped[i - 1], notSwapped[i - 1]);
            }
        }
        //System.out.println(Arrays.toString(notSwapped));
        //System.out.println(Arrays.toString(swapped));
        return Math.min(notSwapped[nums1.length - 1], swapped[nums1.length - 1]);
    }
}
