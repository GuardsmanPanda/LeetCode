package Problem100;

import Types.TreeNode;

public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return preInTree(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
    }

    private TreeNode preInTree(int preLeft, int preRight, int inLeft, int inRight, int[] pre, int[] in) {
        TreeNode node = new TreeNode(pre[preLeft]);
        int split = inRight;
        while (in[split] != pre[preLeft]) split--;
        if (split != inLeft)
            node.left = preInTree(preLeft+1, preLeft+split-inLeft, inLeft, split-1, pre, in);
        if (split != inRight)
            node.right = preInTree(preLeft+split-inLeft+1, preRight, split+1, inRight, pre, in);
        return node;
    }
}
