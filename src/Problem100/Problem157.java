package Problem100;

import Types.Reader4;

public class Problem157 {
    class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            char[] buf4 = new char[4];
            int idx = 0;
            while (idx < n) {
                int read = read4(buf4);
                for (int i = 0; i < read; i++) {
                    if (idx < n) {
                        buf[idx++] = buf4[i];
                    }
                }
                if (read < 4) {
                    break;
                }
            }
            return idx;
        }
    }
}
