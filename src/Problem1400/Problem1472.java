package Problem1400;

import java.util.List;

public class Problem1472 {
    class BrowserHistory {
        private String[] history = new String[5002];
        private int index = 0;
        private int size = 1;

        public BrowserHistory(String homepage) {
            history[index++] = homepage;
        }

        public void visit(String url) {
            history[index++] = url;
            size = index;
        }

        public String back(int steps) {
            index = Math.max(1, index - steps);
            return history[index - 1];
        }

        public String forward(int steps) {
            index = Math.min(size, index + steps);
            return history[index - 1];
        }
    }
}
