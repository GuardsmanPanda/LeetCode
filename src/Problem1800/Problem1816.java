package Problem1800;

public class Problem1816 {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++) {
            result.append(words[i]).append(" ");
        }
        return result.substring(0, result.length() - 1);
    }
}
