package Problem900;

import Types.TreeNode;

import java.util.*;

public class Problem968 {
    private int count = 0;

    public int minCameraCover(TreeNode root) {
        int state = cameraState(root);
        return state == 0 ? count + 1 : count;
    }

    private int cameraState(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }
        int rightState = node.right == null ? 1 : cameraState(node.right);
        int leftState = node.left == null ? 1 : cameraState(node.left);
        if (leftState == 0 || rightState == 0) {
            count++;
            return 2;
        }
        return leftState == 2 || rightState == 2 ? 1 : 0;
    }
}
