package Problem100;

import Types.Reader4;

public class Problem158 {
    public class Solution extends Reader4 {
        private char[] buffer = new char[4];
        private int bufferLength = 0;
        private int bufferIndex = 0;

        public int read(char[] buf, int n) {
            int readChars = 0;
            while (readChars < n) {
                if (bufferIndex == bufferLength) {
                    bufferLength = read4(buffer);
                    bufferIndex = 0;
                }
                if (bufferLength == 0) {
                    break;
                }
                while (readChars < n && bufferIndex < bufferLength) {
                    buf[readChars++] = buffer[bufferIndex++];
                }
            }
            return readChars;
        }
    }
}
