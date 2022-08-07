package Special;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class StockPrice {
    private final HashMap<Integer, Integer> prices = new HashMap<>();
    private final PriorityQueue<int[]> minPrice = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    private final PriorityQueue<int[]> maxPrice = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));

    private int latestTimestamp = 0;
    private int latestPrice = 0;

    public void update(int timestamp, int price) {
        prices.put(timestamp, price);
        if (timestamp >= latestTimestamp) {
            latestTimestamp = timestamp;
            latestPrice = price;
        }
        int[] arr = new int[]{price, timestamp};
        minPrice.add(arr);
        maxPrice.add(arr);
    }

    public int current() {
        return latestPrice;
    }

    public int maximum() {
        int[] arr = maxPrice.peek();
        while (prices.get(arr[1]) != arr[0]) {
            maxPrice.remove();
            arr = maxPrice.peek();
        }
        return arr[0];
    }

    public int minimum() {
        int[] arr = minPrice.peek();
        while (prices.get(arr[1]) != arr[0]) {
            minPrice.remove();
            arr = minPrice.peek();
        }
        return arr[0];
    }
}
