package Problem1300;

import Types.ListNode;
import Types.TreeNode;

public class Problem1367 {
    private boolean found = false;

    public boolean isSubPath(ListNode head, TreeNode root) {
        return search(head, root, false);
    }

    private boolean search(ListNode head, TreeNode root, boolean onPath) {
        if (head == null || found) {
            found = true;
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val == root.val && (search(head.next, root.left, true) || search(head.next, root.right, true))) {
            return true;
        }
        if (!onPath) {
            return search(head, root.left, false) || search(head, root.right, false);
        }
        return false;
    }
}
