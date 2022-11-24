package Problem500;

public class Problem564 {
    public String nearestPalindromic(String n) {
        if (n.length() == 1 || n.equals("10")) {
            return n.equals("0") ? "1" : String.valueOf(Integer.parseInt(n) - 1);
        }
        if (n.matches("^10*1?$")) {
            return n.substring(1).replaceAll("[01]", "9");
        }
        if (n.matches("^99+$")) {
            return "1" + n.substring(1).replaceAll("9", "0") + "1";
        }
        long val = Long.parseLong(n); // ### -> 1, #### -> 2, ##### -> 2
        int mul = 1;
        for (int i = 0; i < n.length() / 2; i++) {
            mul *= 10;
        }
        long higher = val + mul;
        long lower = val - mul;
        char[] arr = n.toCharArray(), arr2 = Long.toString(higher).toCharArray(), arr3 = Long.toString(lower).toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            arr[arr.length - 1 - i] = arr[i];
        }
        for (int i = 0; i < arr2.length / 2; i++) {
            arr2[arr2.length - 1 - i] = arr2[i];
        }
        for (int i = 0; i < arr3.length / 2; i++) {
            arr3[arr3.length - 1 - i] = arr3[i];
        }
        String candidate = new String(arr3);
        long dist = Math.abs(Long.parseLong(new String(arr)) - val);
        long dist2 = Long.parseLong(new String(arr2)) - val;
        long dist3 = val - Long.parseLong(new String(arr3));
        if (dist < dist3 && !new String(arr).equals(n)) {
            candidate = new String(arr);
            dist3 = dist;
        }
        if (dist2 < dist3) {
            candidate = new String(arr2);
        }
        return candidate;
    }
}
