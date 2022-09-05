package Problem200;

public class Problem214 {
    public String shortestPalindrome(String s) {
        char[] arr = s.toCharArray();
        for (int i = arr.length-1; i >= 0; i--) {
            if (isPrefixPalindrome(i, arr)) {
                StringBuilder sb = new StringBuilder();
                for (int k = arr.length-1; k > i; k--) sb.append(arr[k]);
                sb.append(s);
                return sb.toString();
            }
        }
        return "";
    }

    private boolean isPrefixPalindrome(int end, char[] a) {
        for (int i = 0; i <= end/2; i++)
            if (a[i] != a[end-i])
                return false;
        return true;
    }
}
