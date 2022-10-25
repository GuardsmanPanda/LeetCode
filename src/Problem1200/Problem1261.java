package Problem1200;

import Types.TreeNode;

public class Problem1261 {
    class FindElements {
        private final boolean[] found = new boolean[1100001];
        public FindElements(TreeNode root) {
            fixTree(root, 0);
        }

        public boolean find(int target) {
            return found[target];
        }

        private void fixTree(TreeNode node, int val) {
            if (node == null) {
                return;
            }
            found[val] = true;
            fixTree(node.left, val * 2 + 1);
            fixTree(node.right, val * 2 + 2);
        }
    }
}
