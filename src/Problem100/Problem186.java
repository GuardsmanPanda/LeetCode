package Problem100;

public class Problem186 {
    public void reverseWords(char[] s) {
        char[] temp = new char[s.length + 1];
        int start = s.length - 1, end = s.length - 1;
        int tempIdx = 0;
        while (start >= 0) {
            while (start > 0 && s[start] != ' ') start--;
            for (int i = start == 0 ? start : start + 1; i <= end; i++) {
                temp[tempIdx++] = s[i];
            }
            temp[tempIdx++] = ' ';
            end = start - 1;
            start = end;
        }
        System.arraycopy(temp, 0, s, 0, s.length);
    }
}
