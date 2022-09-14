package Problem1400;

import Types.TreeNode;

import java.util.Arrays;

public class Problem1457 {
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[11];
        fillCounter(root, count);
        return count[0];
    }

    private void fillCounter(TreeNode node, int[] counter) {
        if (node == null) {
            return;
        }
        counter[10] += ++counter[node.val] % 2 == 0 ? -1 : 1;
        if (node.left == null && node.right == null) {
            counter[0] += counter[10] < 2 ? 1 : 0;
        } else {
            fillCounter(node.right, counter);
            fillCounter(node.left, counter);
        }
        counter[10] += --counter[node.val] % 2 == 0 ? -1 : 1;
    }
}
