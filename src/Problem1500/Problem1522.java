package Problem1500;

import Types.Node;

public class Problem1522 {
    private int maxDiameter = 0;

    public int diameter(Node root) {
        calcMaxDiameter(root);
        return maxDiameter;
    }

    private int calcMaxDiameter(Node node) {
        if (node == null) return 0;
        int largest = 0, secondLargest = 0;
        for (Node child : node.children) {
            int length = calcMaxDiameter(child);
            if (length > largest) {
                secondLargest = largest;
                largest = length;
            }
            else if (length > secondLargest) {
                secondLargest = length;
            }
        }
        maxDiameter = Math.max(maxDiameter, largest + secondLargest);
        return largest + 1;
    }
}
