package Problem1600;

import Types.Node;

import java.util.Arrays;

public class Problem1612 {
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] count = new int[26];
        doCount(root1, count, 1);
        doCount(root2, count, -1);
        return Arrays.stream(count).allMatch(i -> i == 0);
    }

    private void doCount(Node root, int[] count, int val) {
        if (root != null) {
            if (root.val != '+') {
                count[root.val - 'a'] += val;
            }
            doCount(root.left, count, val);
            doCount(root.right, count, val);
        }
    }
}
