package Problem600;

import java.util.ArrayList;
import java.util.List;

public class Problem635 {
    class LogSystem {
        record Log(int id, String[] timestamp) { }

        private final List<Log> logs = new ArrayList<>();

        public void put(int id, String timestamp) {
            logs.add(new Log(id, timestamp.split(":")));
        }

        public List<Integer> retrieve(String start, String end, String granularity) {
            int index = switch (granularity) {
                case "Year" -> 0;
                case "Month" -> 1;
                case "Day" -> 2;
                case "Hour" -> 3;
                case "Minute" -> 4;
                case "Second" -> 5;
                default -> throw new IllegalArgumentException("Unexpected value: " + granularity);
            };
            String[] startTimestamp = start.split(":");
            String[] endTimestamp = end.split(":");
            List<Integer> result = new ArrayList<>();
            for (Log log : logs) {
                int startDiffIdx = 0, endDiffIdx = 0;
                while (startDiffIdx < index && startTimestamp[startDiffIdx].equals(log.timestamp()[startDiffIdx])) {
                    startDiffIdx++;
                }
                while (endDiffIdx < index && endTimestamp[endDiffIdx].equals(log.timestamp()[endDiffIdx])) {
                    endDiffIdx++;
                }
                if (startTimestamp[startDiffIdx].compareTo(log.timestamp()[startDiffIdx]) <= 0
                        && log.timestamp()[endDiffIdx].compareTo(endTimestamp[endDiffIdx]) <= 0) {
                    result.add(log.id());
                }
            }
            return result;
        }
    }
}
