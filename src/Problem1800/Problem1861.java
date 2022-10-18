package Problem1800;

import java.util.Arrays;

public class Problem1861 {
    public char[][] rotateTheBox(char[][] box) {
        for (char[] arr : box) {
            for (int i = 0, start = 0; i < arr.length; i++) {
                if (arr[i] == '*' || i == arr.length - 1) {
                    int dotCount = 0;
                    for (int j = start; j <= i; j++) {
                        dotCount += arr[j] == '.' ? 1 : 0;
                    }
                    for (int j = start; j <= i; j++) {
                        arr[j] = dotCount-- > 0 ? '.' : arr[j] != '*' ? '#' : '*';
                    }
                    start = i + 1;
                }
            }
        }
        char[][] res = new char[box[0].length][box.length];
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                res[j][box.length - i - 1] = box[i][j];
            }
        }
        return res;
    }
}
