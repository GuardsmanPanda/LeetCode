package Problem100;

public class Problem115 {
    public int numDistinct(String s, String t) {
        int[] count = new int[t.length()+1];
        char[] ta = t.toCharArray();
        count[0] = 1;
        for (char c : s.toCharArray()) {
            for (int i = ta.length - 1; i >= 0; i--) {
                if (c == ta[i]) count[i+1] += count[i];
            }
        }
        return count[t.length()];
    }
}
