package Problem1500;

import Types.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem1586 {
    class BSTIterator {
        private final List<TreeNode> nodes = new ArrayList<>();
        private int index = -1;

        public BSTIterator(TreeNode root) {
            inOrder(root);
        }

        public boolean hasNext() {
            return index < nodes.size() - 1;
        }

        public int next() {
            return nodes.get(++index).val;
        }

        public boolean hasPrev() {
            return index > 0;
        }

        public int prev() {
            return nodes.get(--index).val;
        }

        private void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            nodes.add(node);
            inOrder(node.right);
        }
    }
}
