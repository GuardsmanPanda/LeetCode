package Problem2400;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Problem2456 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Integer> mostPopularVideo = new HashMap<>();
        Map<String, Long> viewsByCreator = new HashMap<>();
        long maxViews = 0;
        for (int i = 0; i < creators.length; i++) {
            String s = creators[i];
            int view = views[i];
            Long cur = viewsByCreator.compute(s, (k, v) -> v == null ? view : v + view);
            maxViews = Math.max(maxViews, cur);
            Integer pop = mostPopularVideo.get(s);
            if (pop == null || views[i] > views[pop] || views[i] == views[pop] && ids[i].compareTo(ids[pop]) < 0) {
                mostPopularVideo.put(s, i);
            }
        }
        long mm = maxViews;
        return viewsByCreator.entrySet().stream()
                .filter(e -> e.getValue() == mm)
                .map(e -> List.of(e.getKey(), ids[mostPopularVideo.get(e.getKey())]))
                .toList();
    }
}
