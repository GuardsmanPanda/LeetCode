package Problem1500;

public class Problem1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles, empty = numBottles;
        while (empty >= numExchange) {
            int newBottles = empty / numExchange;
            result += newBottles;
            empty = newBottles + empty % numExchange;
        }
        return result;
    }
}
