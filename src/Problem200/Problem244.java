package Problem200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem244 {
    class WordDistance {
        HashMap<String, List<Integer>> distMap = new HashMap<>();

        public WordDistance(String[] wordsDict) {
            for (int i = 0; i < wordsDict.length; i++) {
                var list = distMap.computeIfAbsent(wordsDict[i], k -> new ArrayList<>());
                list.add(i);
            }
        }

        public int shortest(String word1, String word2) {
            var i1 = distMap.get(word1);
            var i2 = distMap.get(word2);
            int idx1 = 0, idx2 = 0, minDist = Integer.MAX_VALUE;
            while (idx1 < i1.size() && idx2 < i2.size()) {
                minDist = Math.min(minDist, Math.abs(i1.get(idx1)-i2.get(idx2)));
                if (i1.get(idx1) < i2.get(idx2)) {
                    idx1++;
                } else {
                    idx2++;
                }
            }
            return minDist;
        }
    }
}
