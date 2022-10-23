package Problem2000;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class Problem2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max = 0, idf = 0, idt = 0, kt = k, kf = k;
        char[] arr = answerKey.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            kt -= arr[i] == 'T' ? 0 : 1;
            kf -= arr[i] == 'F' ? 0 : 1;
            while (kt < 0) {
                kt += arr[idt++] == 'T' ? 0 : 1;
            }
            while (kf < 0) {
                kf += arr[idf++] == 'F' ? 0 : 1;
            }
            max = Math.max(max, i - idt + 1);
            max = Math.max(max, i - idf + 1);
        }
        return max;
    }
}
