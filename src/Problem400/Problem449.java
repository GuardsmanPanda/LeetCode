package Problem400;

import Types.TreeNode;

public class Problem449 {
    public class Codec {
        StringBuilder builder = new StringBuilder();
        public String serialize(TreeNode root) {
            builder = new StringBuilder();
            buildString(root);
            builder.append(',');
            return builder.toString();
        }
        private void buildString(TreeNode node) {
            builder.append(',');
            if (node != null) {
                builder.append(node.val);
                buildString(node.left);
                buildString(node.right);
            }
        }
        int index = 0;
        public TreeNode deserialize(String data) {
            index = 0;
            return buildTree(data);
        }
        private TreeNode buildTree(String data) {
            index++;
            int value = data.charAt(index) - '0';
            if (value == ',' - '0') return null;
            while (data.charAt(++index) != ',')
                value = value*10 + data.charAt(index) - '0';
            TreeNode node = new TreeNode(value);
            node.left = buildTree(data);
            node.right = buildTree(data);
            return node;
        }
    }
}
