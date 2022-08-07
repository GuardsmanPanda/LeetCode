public class Problem2351 {
    public char repeatedCharacter(String s) {
        boolean[] found = new boolean[128];
        for (char c : s.toCharArray()) {
            if (found[c]) return c;
            found[c] = true;
        }
        return ' ';
    }
}
