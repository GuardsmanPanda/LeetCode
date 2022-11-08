package Problem900;

public class Problem901 {
    class StockSpanner {
        int[] prices = new int[5000];
        int[] days = new int[5000];
        int day = 0, idx = -1;
        public StockSpanner() {
            prices[++idx] = Integer.MAX_VALUE;
            days[idx] = day++;
        }

        public int next(int price) {
            while (prices[idx] <= price) idx--;
            int res = day-days[idx];
            prices[++idx] = price;
            days[idx] = day++;
            return res;
        }
    }
}
