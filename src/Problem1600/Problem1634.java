package Problem1600;

import Types.PolyNode;

public class Problem1634 {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode res = new PolyNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
        PolyNode cur = res;
        while (poly1 != null && poly2 != null) {
            if (poly1.power > poly2.power) {
                cur.next = new PolyNode(poly1.coefficient, poly1.power);
                poly1 = poly1.next;
            } else if (poly1.power < poly2.power) {
                cur.next = new PolyNode(poly2.coefficient, poly2.power);
                poly2 = poly2.next;
            } else {
                if (poly1.coefficient + poly2.coefficient == 0) {
                    poly1 = poly1.next;
                    poly2 = poly2.next;
                    continue;
                }
                cur.next = new PolyNode(poly1.coefficient + poly2.coefficient, poly1.power);
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
            cur = cur.next;
        }
        while (poly1 != null) {
            cur.next = new PolyNode(poly1.coefficient, poly1.power);
            poly1 = poly1.next;
            cur = cur.next;
        }
        while (poly2 != null) {
            cur.next = new PolyNode(poly2.coefficient, poly2.power);
            poly2 = poly2.next;
            cur = cur.next;
        }
        return res.next;
    }
}
