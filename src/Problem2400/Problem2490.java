package Problem2400;

public class Problem2490 {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 1; i < words.length; i++) {
            int lenLast = words[i-1].length();
            if (words[i-1].charAt(lenLast-1) != words[i].charAt(0)) {
                return false;
            }
        }
        return words[0].charAt(0) == words[words.length - 1].charAt(words[words.length - 1].length() - 1);
    }
}
