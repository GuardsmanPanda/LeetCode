package Problem2100;

public class Problem2138 {
    public String[] divideString(String s, int k, char fill) {
        String[] result = new String[(s.length() + k - 1) / k];
        int index = 0;
        for (int i = 0; i < s.length(); i += k) {
            result[index++] = s.substring(i, Math.min(i + k, s.length()));
        }
        if (result[result.length - 1].length() < k) {
            result[result.length - 1] += ("" + fill).repeat(k - result[result.length - 1].length());
        }
        return result;
    }
}
