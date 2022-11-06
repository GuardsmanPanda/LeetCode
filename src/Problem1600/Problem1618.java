package Problem1600;

import Types.FontInfo;

public class Problem1618 {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int left = 0, right = fonts.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (fontInfo.getHeight(fonts[mid]) <= h && check(text, w, fonts[mid], fontInfo)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return fontInfo.getHeight(fonts[left]) <= h && check(text, w, fonts[left], fontInfo) ? fonts[left] : -1;
    }

    private boolean check(String text, int w, int fontSize, FontInfo fontInfo) {
        return text.chars().map(c -> fontInfo.getWidth(fontSize, (char) c)).sum() <= w;
    }
}
