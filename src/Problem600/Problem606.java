package Problem600;

import Types.TreeNode;

public class Problem606 {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left.isEmpty() && right.isEmpty()) return ""+t.val;
        else if (right.isEmpty()) return t.val + "("+left+")";
        else return t.val +"("+left+")("+right+")";
    }
}
