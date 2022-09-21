package Problem2400;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2408 {


    class SQL {
        private final Map<String, Map<Integer, List<String>>> tables = new HashMap<>();
        private final Map<String, Integer> counter = new HashMap<>();

        public SQL(List<String> names, List<Integer> columns) {
            for (String name : names) {
                tables.put(name, new HashMap<>());
                counter.put(name, 0);
            }
        }

        public void insertRow(String name, List<String> row) {
            Map<Integer, List<String>> table = tables.get(name);
            table.put(counter.compute(name, (k, v) -> v + 1), row);
        }

        public void deleteRow(String name, int rowId) {
            tables.get(name).remove(rowId);
        }

        public String selectCell(String name, int rowId, int columnId) {
            return tables.get(name).get(rowId).get(columnId - 1);
        }
    }
}
