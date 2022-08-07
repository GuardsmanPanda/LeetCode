public class Problem2224 {
    public int convertTime(String current, String correct) {
        int currentTime = (current.charAt(0) - '0') * 10 * 60;
        currentTime += (current.charAt(1) - '0') * 60;
        currentTime += (current.charAt(3) - '0') * 10 + (current.charAt(4) - '0');

        int correctTime = (correct.charAt(0) - '0') * 10 * 60;
        correctTime += (correct.charAt(1) - '0') * 60;
        correctTime += (correct.charAt(3) - '0') * 10 + (correct.charAt(4) - '0');

        int ops = 0;
        if (correctTime < 60) {
            correctTime += 60;
            currentTime += 60;
            currentTime %= 24 * 60;
        }
        while (currentTime > correctTime) {
            currentTime += 60;
            currentTime %= 24 * 60;
            ops++;
        }
        while (currentTime + 60 <= correctTime) {
            currentTime += 60;
            ops++;
        }
        while (currentTime + 15 <= correctTime) {
            currentTime += 15;
            ops++;
        }
        while (currentTime + 5 <= correctTime) {
            currentTime += 5;
            ops++;
        }
        while (currentTime + 1 <= correctTime) {
            currentTime += 1;
            ops++;
        }
        return ops;
    }
}
