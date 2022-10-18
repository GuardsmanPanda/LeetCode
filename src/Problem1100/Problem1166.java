package Problem1100;

import java.util.HashMap;
import java.util.Map;

public class Problem1166 {
    class FileSystem {
        private final Map<String, Integer> paths = new HashMap<>();

        public FileSystem() {
            paths.put("", -1);
        }

        public boolean createPath(String path, int value) {
            String check = path.substring(0, path.lastIndexOf('/'));
            if (!paths.containsKey(check) || paths.containsKey(path)) {
                return false;
            }
            paths.put(path, value);
            return true;
        }

        public int get(String path) {
            return paths.getOrDefault(path, -1);
        }
    }
}
