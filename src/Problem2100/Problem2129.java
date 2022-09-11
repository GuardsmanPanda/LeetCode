package Problem2100;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem2129 {
    public String capitalizeTitle(String title) {
        return Arrays.stream(title.split(" "))
                .map(s -> s.length() < 3 ? s.toLowerCase() : (s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase()))
                .collect(Collectors.joining(" "));
    }
}
