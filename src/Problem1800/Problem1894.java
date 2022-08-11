package Problem1800;

public class Problem1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }
        long newK = k % sum;
        for (int i = 0; i < chalk.length; i++) {
            newK -= chalk[i];
            if (newK < 0) {
                return i;
            }
        }
        return -1;
    }
}
