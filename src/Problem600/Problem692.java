package Problem600;

import java.util.*;

public class Problem692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) wordCount.merge(word, 1, (a, b) -> a + b);
        List<String> output = new ArrayList<>(k);
        Object[][] arr = new Object[wordCount.size()][2];
        int index = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            arr[index][0] = entry.getKey();
            arr[index++][1] = entry.getValue();
        }
        Arrays.sort(arr, Comparator.comparingInt((Object[] a) -> (Integer)a[1]).reversed().thenComparing(a -> (String)a[0]));
        for (int i = 0; i < k; i++) output.add((String)arr[i][0]);
        return output;
    }
}
