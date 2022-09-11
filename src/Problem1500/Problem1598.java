package Problem1500;

import java.util.Arrays;

public class Problem1598 {
    public int minOperations(String[] logs) {
        return Arrays.stream(logs).reduce(0, (acc, log) -> switch (log) {
            case "../" -> Math.max(0, acc - 1);
            case "./" -> acc;
            default -> acc + 1;
        }, Integer::sum);
    }
}
