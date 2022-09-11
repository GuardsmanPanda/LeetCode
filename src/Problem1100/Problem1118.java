package Problem1100;

public class Problem1118 {
    public int numberOfDays(int year, int month) {
        return switch (month) {
            case 2 -> year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }
}
