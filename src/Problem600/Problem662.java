package Problem600;

import Types.TreeNode;

import java.util.ArrayDeque;

public class Problem662 {
    public int widthOfBinaryTree(TreeNode root) {
        ArrayDeque<Integer> indexQ = new ArrayDeque<>();
        ArrayDeque<TreeNode> nodeQ = new ArrayDeque<>();
        indexQ.add(1); nodeQ.add(root);
        int lvlSize = 1, maxWidth = 0, currentMin = 1;
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.removeFirst();
            lvlSize--;
            if (node.left != null) {
                indexQ.addLast(indexQ.peekFirst()*2);
                nodeQ.addLast(node.left);
            }
            if (node.right != null) {
                indexQ.addLast(indexQ.peekFirst()*2+1);
                nodeQ.addLast(node.right);
            }
            if (lvlSize == 0) {
                maxWidth = Math.max(maxWidth, indexQ.removeFirst()-currentMin+1);
                lvlSize = nodeQ.size();
                if (lvlSize > 0) currentMin = indexQ.peekFirst();
            } else indexQ.removeFirst();
        }
        return maxWidth;
    }
}
