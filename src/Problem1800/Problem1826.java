package Problem1800;

public class Problem1826 {
    public int badSensor(int[] sensor1, int[] sensor2) {
        int i = 0;
        while (i < sensor1.length && sensor1[i] == sensor2[i]) {
            i++;
        }
        if (i == sensor1.length) {
            return -1;
        }
        for (int k = i + 1; k < sensor1.length; k++) {
            if (sensor1[k] != sensor2[k - 1]) {
                return 1;
            }
            if (sensor1[k - 1] != sensor2[k]) {
                return 2;
            }
        }
        return -1;
    }
}
