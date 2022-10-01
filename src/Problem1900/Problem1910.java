package Problem1900;

public class Problem1910 {
    public String removeOccurrences(String s, String part) {
        System.out.println(s);
        return s.contains(part) ? removeOccurrences(s.replaceFirst(part, ""), part) : s;
    }
}
