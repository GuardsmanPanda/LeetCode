package Problem2100;

import java.util.Arrays;

public class Problem2114 {
    public int mostWordsFound(String[] sentences) {
        return Arrays.stream(sentences).mapToInt(x -> x.split(" ").length).max().orElse(0);
    }
}
