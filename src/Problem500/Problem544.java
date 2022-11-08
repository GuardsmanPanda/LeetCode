package Problem500;

public class Problem544 {
    public String findContestMatch(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i+1);
        }
        while (n > 1) {
            for (int i = 0; i < n/2; i++) {
                arr[i] = "(" + arr[i] + "," + arr[n-i-1] + ")";
            }
            n /= 2;
        }
        return arr[0];
    }
}
