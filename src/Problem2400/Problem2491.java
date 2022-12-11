package Problem2400;

import java.util.Arrays;

public class Problem2491 {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int target = skill[0] + skill[skill.length - 1];
        long result = 0;
        for (int i = 0; i < skill.length / 2; i++) {
            int sum = skill[i] + skill[skill.length - i - 1];
            if (sum != target) {
                return -1;
            }
            result += (long)skill[i] * skill[skill.length - i - 1];
        }
        return result;
    }
}
