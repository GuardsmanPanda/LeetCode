package Problem1300;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem1366 {
    public String rankTeams(String[] votes) {
        int[][] count = new int[26][votes[0].length()];
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                count[vote.charAt(i) - 'A'][i]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        votes[0].chars().boxed()
                .sorted((a, b) -> {
                    for (int i = 0; i < votes[0].length(); i++) {
                        if (count[a - 'A'][i] != count[b - 'A'][i]) {
                            return count[b - 'A'][i] - count[a - 'A'][i];
                        }
                    }
                    return a - b;
                }).forEach(sb::appendCodePoint);
        return sb.toString();
    }
}
