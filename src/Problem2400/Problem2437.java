package Problem2400;

public class Problem2437 {
    public int countTime(String time) {
        char[] t = {time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4)};
        return getCount(t, 0);
    }

    private int getCount(char[] time, int idx) {
        int counter = idx == 4 ? isValid(time) : 0;
        if (idx < 4) {
            if (time[idx] == '?') {
                for (char c = '0'; c <= '9'; c++) {
                    time[idx] = c;
                    counter += getCount(time, idx + 1);
                }
                time[idx] = '?';
            } else {
                counter += getCount(time, idx + 1);
            }
        }
        return counter;
    }

    private int isValid(char[] time) {
        boolean valid = time[0] <= '2';
        if (time[0] == '2') {
            valid = time[1] <= '3';
        }
        return valid && time[2] <= '5' ? 1 : 0;
    }
}
