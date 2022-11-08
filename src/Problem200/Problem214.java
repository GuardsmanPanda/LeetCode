package Problem200;

public class Problem214 {
    public String shortestPalindrome(String s) {
        char[] arr = s.toCharArray();
        long hash = 0, revHash = 0, base = 1;
        long mul = 139, mod = 111111111111111L;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * mul + arr[i]) % mod;
            revHash = (revHash + arr[i] * base) % mod;
            base = (base * mul) % mod;
            if (hash == revHash) {
                idx = i;
            }
        }
        StringBuilder sb = new StringBuilder(s.length() * 2);
        for (int i = s.length() - 1; i > idx; i--) {
            sb.append(arr[i]);
        }
        return sb.append(s).toString();
    }
}
