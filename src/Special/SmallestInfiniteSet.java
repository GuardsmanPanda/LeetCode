package Special;

import java.util.TreeSet;

public class SmallestInfiniteSet {
    TreeSet<Integer> added = new TreeSet<>();
    int nextVal = 1;

    public int popSmallest() {
        return added.size() > 0 ? added.pollFirst() :nextVal++;
    }

    public void addBack(int num) {
        if (num < nextVal) {
            added.add(num);
        }
    }
}
