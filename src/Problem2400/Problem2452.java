package Problem2400;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String q : queries) {
            for (String s : dictionary) {
                long diff = IntStream.range(0, q.length()).filter(i -> q.charAt(i) != s.charAt(i)).count();
                if (diff < 3) {
                    res.add(q);
                    break;
                }
            }
        }
        return res;
    }
}
