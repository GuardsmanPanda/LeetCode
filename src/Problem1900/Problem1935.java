package Problem1900;

public class Problem1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        for (String word : text.split(" ")) {
            int isBroken = 1;
            for (char c : brokenLetters.toCharArray()) {
                if (word.contains(String.valueOf(c))) {
                    isBroken = 0;
                    break;
                }
            }
            count += isBroken;
        }
        return count;
    }
}
