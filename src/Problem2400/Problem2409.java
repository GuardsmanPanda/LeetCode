package Problem2400;

public class Problem2409 {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String arrive = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String leave = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
        int arriveMonth = Integer.parseInt(arrive.substring(0, 2));
        int arriveDay = Integer.parseInt(arrive.substring(3, 5));
        int leaveMonth = Integer.parseInt(leave.substring(0, 2));
        int leaveDay = Integer.parseInt(leave.substring(3, 5));
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        while (arriveMonth < leaveMonth) {
            days += monthDays[arriveMonth - 1] - arriveDay + 1;
            arriveMonth++;
            arriveDay = 1;
        }
        return arriveMonth == leaveMonth && leaveDay >= arriveDay ? days + leaveDay - arriveDay + 1 : 0;
    }
}
