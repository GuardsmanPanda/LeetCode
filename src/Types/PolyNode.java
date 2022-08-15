package Types;

public class PolyNode {
    public int coefficient, power;
    public PolyNode next = null;

    public PolyNode(int x, int y) {
        this.coefficient = x;
        this.power = y;
    }

    public PolyNode(int x, int y, PolyNode next) {
        this.coefficient = x;
        this.power = y;
        this.next = next;
    }
}
