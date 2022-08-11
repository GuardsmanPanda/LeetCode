package Problem200;

import java.util.HashMap;
import java.util.Map;

public class Problem294 {
    public boolean canWin(String currentState) {
        long state = 0;
        for (char c : currentState.toCharArray()) {
            state = state * 2 + (c == '+' ? 1 : 0);
        }
        return canWin(state, new HashMap<>());
    }

    private boolean canWin(long state, Map<Long, Boolean> winMap) {
        if (winMap.containsKey(state)) {
            return winMap.get(state);
        }
        boolean winChance = false;
        long i = 0b11;
        while (i <= state) {
            if ((state & i) == i) {
                winChance = true;
                break;
            }
            i <<= 1;
        }
        if (winChance) {
            winChance = false;
            while (i <= state) {
                if ((state & i) == i && !canWin(state ^ i, winMap)) {
                    winChance = true;
                    break;
                }
                i <<= 1;
            }
        }
        winMap.put(state, winChance);
        return winChance;
    }
}
