package Problem800;

import Types.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if (K == 0) result.add(target.val);
        else fillKDist(root, target.val, -1, K, result);
        return result;
    }

    private int fillKDist(TreeNode node, int target, int dist, int k, List<Integer> out) {
        if (node == null) return -1;
        int val = node.val;
        if (dist == k) out.add(val);
        if (dist >= k) return -1;
        int downDist = val == target ? 1 : dist == -1 ? -1 : dist+1;
        int right = fillKDist(node.right, target, downDist, k, out);
        int left = fillKDist(node.left, target, downDist, k, out);
        int max = Math.max(right, left);
        if (max == k) out.add(node.val);
        if (max >= k) return -1;
        else if (right > 0) {
            fillKDist(node.left, target, right+1, k, out);
            return right+1;
        }
        else if (left > 0) {
            fillKDist(node.right, target, left+1, k, out);
            return left+1;
        }
        return val == target ? 1 : -1;
    }
}
