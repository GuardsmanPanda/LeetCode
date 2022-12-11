package Problem600;

public class Problem631 {
    class Excel {
        private final String[][][] sum;
        private final int[][] data;

        public Excel(int height, char width) {
            sum = new String[height][width - 'A' + 1][];
            data = new int[height][width - 'A' + 1];
        }

        public void set(int row, char column, int val) {
            data[row - 1][column - 'A'] = val;
            sum[row - 1][column - 'A'] = null;
        }

        public int get(int row, char column) {
            if (sum[row - 1][column - 'A'] == null) {
                return data[row - 1][column - 'A'];
            }
            return getSum(sum[row - 1][column - 'A']);
        }

        public int sum(int row, char column, String[] numbers) {
            sum[row - 1][column - 'A'] = numbers;
            return get(row, column);
        }

        private int getSum(String[] arr) {
            int res = 0;
            for (String s : arr) {
                if (s.contains(":")) {
                    String[] range = s.split(":");
                    int row1 = Integer.parseInt(range[0].substring(1));
                    int row2 = Integer.parseInt(range[1].substring(1));
                    char col1 = range[0].charAt(0);
                    char col2 = range[1].charAt(0);
                    for (int i = row1; i <= row2; i++) {
                        for (char j = col1; j <= col2; j++) {
                            res += get(i, j);
                        }
                    }
                } else {
                    res += get(Integer.parseInt(s.substring(1)), s.charAt(0));
                }
            }
            return res;
        }
    }
}
