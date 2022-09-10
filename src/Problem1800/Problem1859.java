package Problem1800;

public class Problem1859 {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] result = new String[words.length];
        for (String word : words) {
            result[word.charAt(word.length() - 1) - '1'] = word.substring(0, word.length() - 1);
        }
        return String.join(" ", result);
    }
}
