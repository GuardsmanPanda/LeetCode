public class Problem1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int leftEnd = 0, rightEnd = arr.length - 1;
        while (leftEnd < arr.length - 1 && arr[leftEnd] <= arr[leftEnd + 1]) {
            leftEnd++;
        }
        while (rightEnd > 0 && arr[rightEnd] >= arr[rightEnd - 1]) {
            rightEnd--;
        }
        if (leftEnd >= rightEnd) {
            return 0;
        }

        int low = rightEnd - leftEnd - 1, high = arr.length-1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (isIncreasing(arr, mid, leftEnd, rightEnd)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isIncreasing(int[] arr, int skip, int leftEnd, int rightEnd) {
        skip++;
        if (leftEnd + skip >= arr.length || rightEnd - skip < 0) {
            return true;
        }
        for (int i = Math.max(0, rightEnd - skip); i <= Math.min(leftEnd, arr.length - skip - 1); i++) {
            if (arr[i] <= arr[i + skip]) {
                return true;
            }
        }
        return false;
    }
}
