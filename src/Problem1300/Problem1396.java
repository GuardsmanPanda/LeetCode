package Problem1300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1396 {
    class UndergroundSystem {
        private record Customer(String stationName, int time) {}
        private final Map<String, List<Integer>> travels = new HashMap<>();
        private final Map<Integer, Customer> active = new HashMap<>();

        public void checkIn(int id, String stationName, int t) {
            active.put(id, new Customer(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Customer customer = active.remove(id);
            travels.computeIfAbsent(customer.stationName + "-" + stationName, k -> new ArrayList<>()).add(t - customer.time);
        }

        public double getAverageTime(String startStation, String endStation) {
            return travels.get(startStation + "-" + endStation).stream()
                    .mapToInt(i -> i).average().orElse(0);
        }
    }
}
