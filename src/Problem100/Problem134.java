package Problem100;

public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, offset = -1, minGas = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i];
            tank -= cost[i];
            if (tank < minGas) {
                minGas = tank;
                offset = i;
            }
        }
        int currentGas = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[(i+offset+1) % gas.length];
            currentGas -= cost[(i+offset+1) % gas.length];
            if (currentGas < 0) return -1;
        }
        return (offset+1)% gas.length;
    }
}
