package Special;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        return String.join("ø", strs);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> strs = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == 'ø') {
                strs.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        strs.add(sb.toString());
        return strs;
    }
}
