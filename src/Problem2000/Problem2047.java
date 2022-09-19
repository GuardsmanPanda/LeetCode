package Problem2000;

public class Problem2047 {
    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int count = 0;
        for (String word : words) {
            if (word.matches("[a-z]*([a-z]-[a-z]+)?[.,!]?") && word.length() > 0) {
                count++;
            }
        }
        return count;
    }
}
