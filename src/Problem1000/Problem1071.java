package Problem1000;

public class Problem1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        if (!str1.startsWith(str2)) {
            return "";
        }
        if (str2.isEmpty()) {
            return str1;
        }
        return gcdOfStrings(str1.substring(str2.length()), str2);
    }
}
