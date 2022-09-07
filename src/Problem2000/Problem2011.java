package Problem2000;

import java.util.Arrays;

public class Problem2011 {
    public int finalValueAfterOperations(String[] operations) {
        return Arrays.stream(operations).mapToInt(op -> op.charAt(1) == '+' ? 1 : -1).sum();
    }
}
