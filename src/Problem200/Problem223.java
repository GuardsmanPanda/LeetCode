package Problem200;

public class Problem223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long area = ((long)C-A)*(D-B) + ((long)G-E)*(H-F);
        return (int)(area - Math.max(0, Math.min((long)D, H)-Math.max(B,F))*Math.max(0, Math.min((long)C, G)-Math.max(A,E)));
    }
}
