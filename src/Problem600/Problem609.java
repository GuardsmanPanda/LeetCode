package Problem600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> fileMap = new HashMap<>();
        for (String path : paths) {
            int index = path.indexOf(' ');
            String start = path.substring(0, index) + "/";
            while (index > 0) {
                int paren = path.indexOf('(', index);
                String name = path.substring(index + 1, paren);
                String content = path.substring(paren + 1, path.indexOf(')', index));
                if (!fileMap.containsKey(content)) fileMap.put(content, new ArrayList<>());
                fileMap.get(content).add(start + name);
                index = path.indexOf(' ', index + 1);
            }
        }
        List<List<String>> output = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : fileMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                List<String> result = new ArrayList<>(entry.getValue().size());
                result.addAll(entry.getValue());
                output.add(result);
            }
        }
        return output;
    }
}
