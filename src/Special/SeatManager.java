package Special;

import java.util.PriorityQueue;

public class SeatManager {
    private int nextSeat = 1;
    private PriorityQueue<Integer> freeSeats = new PriorityQueue<>();

    public SeatManager(int n) {

    }

    public int reserve() {
        if (freeSeats.isEmpty()) {
            return nextSeat++;
        } else {
            return freeSeats.poll();
        }
    }

    public void unreserve(int seatNumber) {
        freeSeats.add(seatNumber);
    }
}
