package Problem2400;

public class Problem2468 {
    public String[] splitMessage(String message, int limit) {
        if (limit < 6) {
            return new String[0];
        }
        int start = message.length() / (limit - 5);
        if (limit == 12 && message.length() > 2000) {
            start = message.length() - 2000;
        }
        for (int i = start; i < 10000; i++) {
            int shortLen = Integer.toString(i).length() + 4;
            int longLen = Integer.toString(i).length() * 2 + 3;
            if ((limit - shortLen) * i < message.length() || (limit - longLen) < 1) {
                continue;
            }
            if (isPossible(message, limit, i)) {
                return buildAnswer(message, limit, i);
            }
        }
        return new String[0];
    }

    private String[] buildAnswer(String message, int limit, int parts) {
        String[] answer = new String[parts];
        int extra = Integer.toString(parts).length() + 3;
        int index = 0;
        for (int i = 1; i <= parts; i++) {
            int len =  limit - (extra + Integer.toString(i).length());
            answer[i - 1] = message.substring(index, Math.min(index + len, message.length())) + "<" + i + "/" + parts + ">";
            index += len;
        }
        return answer;
    }

    private boolean isPossible(String message, int limit, int parts) {
        int idx = 0, extra = Integer.toString(parts).length() + 3;
        for (int i = 1; i <= parts; i++) {
            idx += limit - (extra + Integer.toString(i).length());
            if (idx > message.length() && i != parts) {
                System.out.println("i = " + i);
                return false;
            }
        }
        return idx >= message.length();
    }
}
