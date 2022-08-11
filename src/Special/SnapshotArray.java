package Special;

import java.util.HashMap;
import java.util.TreeMap;

public class SnapshotArray {
    private final HashMap<Integer, TreeMap<Integer, Integer>> snapMap = new HashMap<>();
    private int snapId = 0;
    public SnapshotArray(int length) {}

    public void set(int index, int val) {
        snapMap.computeIfAbsent(index, k -> new TreeMap<>()).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        var res = snapMap.get(index);
        var entry = res == null ? null : res.floorEntry(snap_id);
        return entry == null ? 0 : entry.getValue();
    }
}
