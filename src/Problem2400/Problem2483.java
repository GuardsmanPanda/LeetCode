package Problem2400;

public class Problem2483 {
    public int bestClosingTime(String customers) {
        char[] chars = customers.toCharArray();
        int penalty = 0;
        for (char c : chars) {
            penalty += c == 'Y' ? 1 : 0;
        }
        int min = penalty, idx = 0;
        for (int i = 0; i < chars.length; i++) {
            penalty += chars[i] == 'Y' ? -1 : 1;
            if (penalty < min) {
                min = penalty;
                idx = i + 1;
            }
        }
        return idx;
    }
}
