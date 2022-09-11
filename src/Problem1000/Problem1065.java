package Problem1000;

import java.util.ArrayList;
import java.util.List;

public class Problem1065 {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> result = new ArrayList<>();
        for (String word : words) {
            int index = text.indexOf(word);
            while (index != -1) {
                result.add(new int[]{index, index + word.length() - 1});
                index = text.indexOf(word, index + 1);
            }
        }
        return result.stream()
                .sorted((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0])
                .toArray(int[][]::new);
    }
}
