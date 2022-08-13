package Problem200;

import Types.TreeNode;

public class Problem297 {
    static class Codec {
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            buildString(root, builder);
            builder.append(',');
            return builder.toString();
        }
        private void buildString(TreeNode node, StringBuilder builder) {
            builder.append(',');
            if (node != null) {
                builder.append(node.val);
                buildString(node.left, builder);
                buildString(node.right, builder);
            }
        }
        public TreeNode deserialize(String data) {
            return buildTree(data, new int[1]);
        }
        private TreeNode buildTree(String data, int[] index) {
            index[0]++;
            int value = data.charAt(index[0]) - '0';
            if (value == ',' - '0') return null;
            int mult = value == '-' - '0' ? -1 : 1;
            if (value == '-' - '0') value = data.charAt(++index[0]) - '0';
            while (data.charAt(++index[0]) != ',')
                value = value*10 + data.charAt(index[0]) - '0';
            value *= mult;
            TreeNode node = new TreeNode(value);
            node.left = buildTree(data, index);
            node.right = buildTree(data, index);
            return node;
        }
    }
}
