package Problem700;

import Types.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> all = schedule.stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(a -> a.start))
                .toList();
        List<Interval> output = new ArrayList<>();
        int end = all.get(0).end;
        for (Interval interval : all) {
            if (interval.start > end) {
                output.add(new Interval(end, interval.start));
            }
            end = Math.max(end, interval.end);
        }
        return output;
    }
}
