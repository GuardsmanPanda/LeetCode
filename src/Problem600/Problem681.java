package Problem600;

import java.util.Arrays;

public class Problem681 {
    public String nextClosestTime(String time) {
        char[] arr = time.toCharArray();
        char[] chars = new char[] {arr[0], arr[1], arr[3], arr[4]};
        Arrays.sort(chars);
        for (char c : chars) {
            if (c > arr[4]) {
                arr[4] = c;
                return new String(arr);
            }
        }
        arr[4] = chars[0];
        for (char c : chars) {
            if (c > arr[3] && c < '6') {
                arr[3] = c;
                return new String(arr);
            }
        }
        arr[3] = chars[0];
        for (char c : chars) {
            if (c > arr[1] && (arr[0] != '2' || c < '4')) {
                arr[1] = c;
                return new String(arr);
            }
        }
        arr[1] = chars[0];
        for (char c : chars) {
            if (c > arr[0] && c < '3') {
                arr[0] = c;
                return new String(arr);
            }
        }
        return new String(new char[] {chars[0], chars[0], ':', chars[0], chars[0]});
    }
}
