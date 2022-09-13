package Problem2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2094 {
    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        List<Integer> tmp = findEvenNumbers(digits, new boolean[digits.length], 0, 0, new ArrayList<>());
        return tmp.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> findEvenNumbers(int[] digits, boolean[] used, int number, int index, List<Integer> res) {
        if (index == 3) {
            res.add(number);
            return res;
        }
        for (int i = 0, last = -1; i < digits.length; i++) {
            int digit = digits[i];
            if (digit == last || used[i] || digit == 0 && index == 0 || digit % 2 != 0 && index == 2) {
                continue;
            }
            used[i] = true;
            findEvenNumbers(digits, used, number * 10 + digit, index + 1, res);
            used[i] = false;
            last = digit;
        }
        return res;
    }
}
