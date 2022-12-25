package Problem2500;

public class Problem2506 {
    public int similarPairs(String[] words) {
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].chars().distinct().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    res++;
                }
            }
        }
        return res;
    }
}
