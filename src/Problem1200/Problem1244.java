package Problem1200;

import java.util.Comparator;
import java.util.HashMap;

public class Problem1244 {
    class Leaderboard {
        private final HashMap<Integer, Integer> scores = new HashMap<>();

        public void addScore(int playerId, int score) {
            scores.compute(playerId, (k, v) -> v == null ? score : v + score);
        }

        public int top(int K) {
            return scores.values().stream().sorted(Comparator.reverseOrder()).limit(K).mapToInt(Integer::intValue).sum();
        }

        public void reset(int playerId) {
            scores.remove(playerId);
        }
    }
}
