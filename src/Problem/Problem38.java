package Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem38 {
    public String countAndSay(int n) {
        if (n == 0) return "";
        List<Integer> oldList = new ArrayList<>();
        oldList.add(1);
        for (int i = 1; i < n; i++) {
            List<Integer> newList = new ArrayList<>();
            for (int index = 0; index < oldList.size(); index++) {
                int value = oldList.get(index);
                int count = 1;
                while (index < oldList.size() - 1 && value == oldList.get(index + 1)) {
                    count++;
                    index++;
                }
                newList.add(count);
                newList.add(value);
            }
            oldList = newList;
        }
        return oldList.stream().map(Object::toString).collect(Collectors.joining());
    }
}
