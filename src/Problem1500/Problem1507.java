package Problem1500;

public class Problem1507 {
    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        String day = parts[0].substring(0, parts[0].length() - 2);
        if (day.length() == 1) {
            day = "0" + day;
        }
        String month = switch (parts[1]) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> throw new IllegalStateException("Unexpected value: " + parts[1]);
        };
        return parts[2] + "-" + month + "-" + day;
    }
}
