package Problem500;

public class Problem564 {
    public String nearestPalindromic(String n) {
        if (n.length() == 1 || n.equals("10")) {
            return n.equals("0") ? "1" : String.valueOf(Integer.parseInt(n) - 1);
        }
        if (n.matches("^10+1?$")) {
            return n.substring(1).replaceAll("[01]", "9");
        }
        if (n.matches("^99+$")) {
            return "1" + n.substring(1).replaceAll("9", "0") + "1";
        }

        char[] top = n.substring(0, (n.length() + 1) / 2).toCharArray();
        char[] bot = n.substring(n.length() / 2).toCharArray();
        long dist = 0, mul = 1;
        for (int i = 0; i < top.length; i++) {
            int i1 = top[i] - '0';
            int i2 = bot[bot.length - i - 1] - '0';
            dist += (i1 - i2) * mul;
            mul *= 10;
            bot[bot.length - i - 1] = top[i];
        }
        System.out.println(Math.abs(dist));
        StringBuilder sb = new StringBuilder();
        if (dist == 0) {
            int zeroCount = 0;
            while (zeroCount < bot.length && bot[zeroCount] == '0') {
                zeroCount++;
            }
            if (zeroCount == 1 && n.length() % 2 == 1) {
                bot[0]++;
                top[top.length - 1]++;
            } else {
                bot[zeroCount]--;
                top[top.length - 1 - zeroCount]--;
                for (int i = zeroCount - 1; i >= 0; i--) {
                    top[top.length - 1 - i] = '9';
                    bot[i] = '9';
                }
            }
        }
        sb.append(top);
        sb.setLength(sb.length() - (n.length() % 2 == 1 ? 1 : 0));
        sb.append(bot);
        return sb.toString();
    }
}
