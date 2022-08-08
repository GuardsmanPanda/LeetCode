public class Problem1249 {
    public String minRemoveToMakeValid(String s) {
        char[] ca = s.toCharArray();
        boolean[] removed = new boolean[ca.length];
        int open = 0;
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == '(') {
                open++;
            } else if (ca[i] == ')') {
                if (open == 0) {
                    removed[i] = true;
                } else {
                    open--;
                }
            }
        }
        open = 0;
        for (int i = ca.length - 1; i >= 0; i--) {
            if (removed[i]) {
                continue;
            }
            if (ca[i] == ')') {
                open++;
            } else if (ca[i] == '(') {
                if (open == 0) {
                    removed[i] = true;
                } else {
                    open--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ca.length; i++) {
            if (!removed[i]) {
                sb.append(ca[i]);
            }
        }
        return sb.toString();
    }
}
