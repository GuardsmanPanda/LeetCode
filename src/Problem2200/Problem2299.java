package Problem2200;

public class Problem2299 {
    public boolean strongPasswordCheckerII(String password) {
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i-1)) {
                return false;
            }
        }
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()+-]).{8,}$");
    }
}
