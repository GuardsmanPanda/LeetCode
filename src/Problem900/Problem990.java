package Problem900;

public class Problem990 {
    public boolean equationsPossible(String[] equations) {
        int[] disjoint = new int[128];
        for (int i = 0; i < disjoint.length; i++) disjoint[i] = i;
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                disjoint[getRoot(eq.charAt(0), disjoint)] = getRoot(eq.charAt(3), disjoint);
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!' && getRoot(eq.charAt(0), disjoint) == getRoot(eq.charAt(3), disjoint)) {
                return false;
            }
        }
        return true;
    }

    private int getRoot(int a, int[] p) {
        return a == p[a] ? a : (p[a] = getRoot(p[a], p));
    }
}
