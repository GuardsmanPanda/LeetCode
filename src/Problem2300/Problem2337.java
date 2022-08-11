package Problem2300;

public class Problem2337 {
    public boolean canChange(String start, String target) {
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < start.length() || idx2 < target.length()) {
            while (idx1 < start.length() && start.charAt(idx1) == '_') {
                idx1++;
            }
            while (idx2 < target.length() && target.charAt(idx2) == '_') {
                idx2++;
            }
            if (idx1 == start.length() && idx2 == target.length()) {
                return true;
            }
            if (idx1 == start.length() || idx2 == target.length() || start.charAt(idx1) != target.charAt(idx2)) {
                return false;
            }
            if ((start.charAt(idx1) == 'L' && idx1 < idx2) || (start.charAt(idx1) == 'R' && idx1 > idx2)) {
                return false;
            }
            idx1++;
            idx2++;
        }
        return true;
    }
}
