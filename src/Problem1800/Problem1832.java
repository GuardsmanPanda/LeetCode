package Problem1800;

public class Problem1832 {
    public boolean checkIfPangram(String sentence) {
        boolean[] letters = new boolean[26];
        for (char c : sentence.toCharArray()) {
            letters[c - 'a'] = true;
        }
        for (boolean letter : letters) {
            if (!letter) {
                return false;
            }
        }
        return true;
    }
}
