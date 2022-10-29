package Problem2400;

public class Problem2451 {
    public String oddString(String[] words) {
        String s1 = words[0];
        String s2 = words[1];
        int count = 0;
        for (int i = 1; i < words.length; i++) {
            String cur = words[i];
            boolean same = true;
            for (int k = 1; k < cur.length(); k++) {
                if (s1.charAt(k) - s1.charAt(k - 1) != cur.charAt(k) - cur.charAt(k - 1)) {
                    same = false;
                    break;
                }
            }
            if (same) {
                count++;
            } else {
                s2 = cur;
            }
        }
        return count == 0 ? s1 : s2;
    }
}
