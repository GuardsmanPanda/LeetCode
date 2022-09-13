package Problem300;

public class Problem393 {
    public boolean validUtf8(int[] data) {
        int state = 0;
        for (int utf : data) {
            if (utf < 128) {
                if (state != 0) return false;
                continue;
            } else if (utf < 192) {
                if (state == 0) return false;
                else state--;
                continue;
            }
            if (state != 0) return false;
            if (utf < 224) state = 1;
            else if (utf < 240) state = 2;
            else if (utf < 248) state = 3;
            else return false;
        }
        return state == 0;
    }
}
