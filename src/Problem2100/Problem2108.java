package Problem2100;

public class Problem2108 {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            boolean isPalindrome = true;
            for (int i = 0; i < word.length() / 2; i++) {
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                return word;
            }
        }
        return "";
    }
}
