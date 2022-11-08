package Problem1600;

import java.util.ArrayList;
import java.util.List;

public class Problem1622 {
    class Fancy {
        private final List<Long> nums = new ArrayList<>();
        private final long mod = 1000000007;
        private long add = 0, mul = 1;

        public void append(int val) {
            nums.add((val - add + mod) * modInverse(mul, mod) % mod);
        }

        public void addAll(int inc) {
            add = (add + inc) % mod;
        }

        public void multAll(int m) {
            add = (add * m) % mod;
            mul = (mul * m) % mod;
        }

        public int getIndex(int idx) {
            if (idx >= nums.size()) {
                return -1;
            }
            return (int) ((nums.get(idx) * mul + add) % mod);
        }

        private long modInverse(long a, long mod) {
            long res = 1, mul = a;
            long exp = mod - 2;
            while (exp > 0) {
                if ((exp & 1) == 1) {
                    res = (res * mul) % mod;
                }
                mul = (mul * mul) % mod;
                exp >>= 1;
            }
            return res;
        }
    }
}
