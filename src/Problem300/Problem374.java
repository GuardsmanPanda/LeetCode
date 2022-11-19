package Problem300;

import Types.GuessGame;

public class Problem374 {
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int low = 1, high = n;
            while (low<high) {
                int mid = (high-low)/2 + low;
                int result = guess(mid);
                if (result == -1) high = mid-1;
                else if (result == 1) low = mid+1;
                else return mid;
            }
            return low;
        }
    }
}
