package Problem700;

public class Problem772 {
    public int calculate(String s) {
        return calculate(s.toCharArray(), 0)[0];
    }

    private int[] calculate(char[] arr, int index) {
        int sum = 0, lastNumber = 0, multiply = 0;
        char lastOp = '+';
        boolean inMultiple = false, plus = true;
        while (index < arr.length) {
            char c = arr[index++];
            if (c == ' ') continue;
            if (c == ')') break;
            else if (c == '+' || c== '-') {
                if (inMultiple) lastNumber = multiply;
                inMultiple = false;
                sum += plus ? lastNumber : -lastNumber;
                plus = c == '+';
            }
            else if (c == '*' || c == '/') {
                if (!inMultiple) multiply = lastNumber;
                inMultiple = true;
                lastOp = c;
            }
            else if (c == '(' || c >= '0') {
                if (c == '(') {
                    int[] result = calculate(arr, index);
                    lastNumber = result[0];
                    index = result[1];
                } else {
                    lastNumber = c-'0';
                    while (index < arr.length && arr[index] >= '0') {
                        lastNumber = lastNumber*10 + arr[index++] - '0';
                    }
                }
                if (inMultiple && lastOp == '*') multiply *= lastNumber;
                if (inMultiple && lastOp == '/') multiply /= lastNumber;
            }
        }
        if (inMultiple) sum += plus ? multiply : -multiply;
        else sum += plus ? lastNumber : -lastNumber;
        return new int[] {sum, index};
    }
}
