package Problem1000;

public class Problem1061 {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[128];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i);
            int c2 = s2.charAt(i);
            int p1 = find(parent, c1);
            int p2 = find(parent, c2);
            if (p1 != p2) {
                if (p1 < p2) {
                    parent[p2] = p1;
                } else {
                    parent[p1] = p2;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int c = baseStr.charAt(i);
            int p = find(parent, c);
            sb.append((char) p);
        }
        return sb.toString();
    }

    private int find(int[] parent, int x) {
        return parent[x] == x ? x : (parent[x] = find(parent, parent[x]));
    }
}
