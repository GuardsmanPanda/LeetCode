package Problem1800;

public class Problem1805 {
    public int numDifferentIntegers(String word) {
        return (int)java.util.regex.Pattern.compile("\\d+").matcher(word).results()
                .map(m -> m.group().replaceFirst("^0+", ""))
                .distinct().count();
    }
}
