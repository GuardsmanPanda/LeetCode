package Problem600;

public class Problem679 {
    public boolean judgePoint24(int[] cards) {
        return evalArr(new double[]{cards[0], cards[1], cards[2], cards[3]});
    }

    private boolean evalArr(double[] arr) {
        if (arr.length == 1) {
            return Math.abs(arr[0] - 24) < 1e-6;
        }
        double[] next = new double[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int ndx = 1;
                for (int k = 0; k < arr.length; k++) {
                    if (k != i && k != j) {
                        next[ndx++] = arr[k];
                    }
                }
                next[0] = arr[i] + arr[j];
                if (evalArr(next)) {
                    return true;
                }
                next[0] = arr[i] - arr[j];
                if (evalArr(next)) {
                    return true;
                }
                next[0] = arr[j] - arr[i];
                if (evalArr(next)) {
                    return true;
                }
                next[0] = arr[i] * arr[j];
                if (evalArr(next)) {
                    return true;
                }
                if (arr[j] != 0) {
                    next[0] = arr[i] / arr[j];
                    if (evalArr(next)) {
                        return true;
                    }
                }
                if (arr[i] != 0) {
                    next[0] = arr[j] / arr[i];
                    if (evalArr(next)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
