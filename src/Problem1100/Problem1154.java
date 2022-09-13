package Problem1100;

public class Problem1154 {
    public int dayOfYear(String date) {
        return java.time.LocalDate.parse(date).getDayOfYear();
    }
}
