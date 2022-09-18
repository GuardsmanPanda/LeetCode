package Problem1700;

public class Problem1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int zero = 0, one = 0;
        for (int student : students) {
            zero += 1 - student;
            one += student;
        }
        for (int i : sandwiches) {
            if (i == 0 && zero-- == 0) {
                return one;
            }
            if (i == 1 && one-- == 0) {
                return zero;
            }
        }
        return 0;
    }
}
