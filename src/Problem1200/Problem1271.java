package Problem1200;

public class Problem1271 {
    public String toHexspeak(String num) {
        long cur = 0;
        for (char c : num.toCharArray()) {
            cur = cur * 10 + c - '0';
        }
        StringBuilder sb = new StringBuilder();
        while (cur > 0) {
            long rem = cur % 16;
            if (rem >= 2 && rem <= 9) {
                return "ERROR";
            }
            char res = switch ((int) rem) {
                case 0 -> 'O';
                case 1 -> 'I';
                default -> (char) (rem - 10 + 'A');
            };
            sb.append(res);
            cur /= 16;
        }
        return sb.reverse().toString();
    }
}
