package Problem1600;

public class Problem1694 {
    public String reformatNumber(String number) {
        String digits = number.replaceAll("[^0-9]+", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            if (i > 0 && i % 3 == 0 && i < digits.length() - 2) {
                sb.append("-");
            }
            if (digits.length() - i == 2 && digits.length() % 3 != 0 && digits.length() > 3) {
                sb.append("-");
            }
            sb.append(digits.charAt(i));
        }
        return sb.toString();
    }
}
