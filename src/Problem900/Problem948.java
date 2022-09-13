package Problem900;

import java.util.Arrays;

public class Problem948 {
    public int bagOfTokensScore(int[] tokens, int P) {
        int points = 0, power = P;
        Arrays.sort(tokens);
        int idx = 0, ndx = tokens.length-1;
        while (idx <= ndx) {
            if (tokens[idx] <= power) {
                power -= tokens[idx++];
                points++;
            }
            else if (points > 0) {
                power += tokens[ndx--];
                points--;
            }
            else break;
        }
        return ndx < tokens.length-1 && power >= tokens[ndx+1] ? points+1 : points;
    }
}
