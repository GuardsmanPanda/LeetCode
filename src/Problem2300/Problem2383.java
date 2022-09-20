package Problem2300;

import java.util.Arrays;

public class Problem2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int es = Arrays.stream(energy).sum();
        int exp = 0;
        for (int ee : experience) {
            if (initialExperience + exp <= ee) {
                exp += ee - initialExperience - exp + 1;
            }
            initialExperience += ee;
        }
        return exp + Math.max(0, es - initialEnergy + 1);
    }
}
