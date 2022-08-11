package Problem1500;

import java.util.Arrays;

public class Problem1562 {
    public int findLatestStep(int[] arr, int m) {
        int[] parent = new int[arr.length + 2];
        int[] size = new int[arr.length + 2];
        Arrays.fill(parent, -1);
        Arrays.fill(size, 1);

        int correct = 0, ans = -1;
        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            parent[item] = item;
            size[item] = 1;
            int p = item;
            if (parent[item - 1] != -1) {
                int p2 = find(parent, item - 1);
                if (size[p2] == m) {
                    correct--;
                }
                parent[p] = p2;
                size[p2]++;
                p = p2;
            }
            if (parent[item + 1] != -1) {
                int p2 = find(parent, item + 1);
                if (size[p2] == m) {
                    correct--;
                }
                parent[p] = p2;
                size[p2] += size[p];
                p = p2;
            }
            if (size[p] == m) {
                correct++;
            }
            if (correct > 0) {
                ans = i + 1;
            }
        }
        return ans;
    }

    private int find(int[] parent, int x) {
        return parent[x] == x ? x : (parent[x] = find(parent, parent[x]));
    }
}
