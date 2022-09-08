package Problem1500;

public class Problem1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parentA = new int[n];
        int[] parentB = new int[n];
        for (int i = 0; i < n; i++) {
            parentA[i] = i;
            parentB[i] = i;
        }
        int countA = n, countB = n;
        int res = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                int p1 = find(parentA, edge[1] - 1);
                int p2 = find(parentA, edge[2] - 1);
                if (p1 == p2) {
                    res++;
                } else {
                    parentA[p1] = p2;
                    parentB[p1] = p2;
                    countA--;
                    countB--;
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                int p1 = find(parentA, edge[1] - 1);
                int p2 = find(parentA, edge[2] - 1);
                if (p1 == p2) {
                    res++;
                } else {
                    parentA[p1] = p2;
                    countA--;
                }
            } else if (edge[0] == 2) {
                int p1 = find(parentB, edge[1] - 1);
                int p2 = find(parentB, edge[2] - 1);
                if (p1 == p2) {
                    res++;
                } else {
                    parentB[p1] = p2;
                    countB--;
                }
            }
        }

        return countA == 1 && countB == 1 ? res : -1;
    }

    private int find(int[] parent, int i) {
        return parent[i] == i ? i : (parent[i] = find(parent, parent[i]));
    }
}
