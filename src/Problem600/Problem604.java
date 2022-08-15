package Problem600;

public class Problem604 {
    class StringIterator {
        private int idx = 0;
        private char last = ' ';
        private int count = 0;
        private final String compressedString;

        public StringIterator(String compressedString) {
            this.compressedString = compressedString;
        }

        public char next() {
            if (idx == compressedString.length() && count == 0) {
                return ' ';
            }
            if (count == 0) {
                last = compressedString.charAt(idx++);
                while (idx < compressedString.length() && Character.isDigit(compressedString.charAt(idx))) {
                    count = count * 10 + compressedString.charAt(idx++) - '0';
                }
            }
            count--;
            return last;
        }

        public boolean hasNext() {
            return idx < compressedString.length() || count > 0;
        }
    }
}
