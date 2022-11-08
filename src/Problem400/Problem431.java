package Problem400;

import Types.Node;
import Types.TreeNode;

import java.util.ArrayList;

public class Problem431 {
    class Codec {
        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }
            return enc(root, true);
        }

        private TreeNode enc(Node node, boolean right) {
            TreeNode res = new TreeNode(node.val);
            TreeNode cur = res;
            for (Node n : node.children) {
                if (right) {
                    cur.right = enc(n, false);
                    cur = cur.right;
                } else {
                    cur.left = enc(n, true);
                    cur = cur.left;
                }
            }
            return res;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            return dec(root, true);
        }

        private Node dec(TreeNode node, boolean right) {
            Node res = new Node(node.val, new ArrayList<>());
            if (right) {
                while (node.right != null) {
                    node = node.right;
                    res.children.add(dec(node, false));
                }
            } else {
                while (node.left != null) {
                    node = node.left;
                    res.children.add(dec(node, true));
                }
            }
            return res;
        }
    }
}
