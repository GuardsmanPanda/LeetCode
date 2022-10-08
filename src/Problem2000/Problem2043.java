package Problem2000;

import java.util.HashMap;
import java.util.Map;

public class Problem2043 {
    class Bank {
        private final Map<Integer, Long> map = new HashMap<>();

        public Bank(long[] balance) {
            for (int i = 0; i < balance.length; i++) {
                map.put(i + 1, balance[i]);
            }
        }

        public boolean transfer(int account1, int account2, long money) {
            if (map.containsKey(account1) && map.containsKey(account2)) {
                long balance1 = map.get(account1);
                if (balance1 >= money) {
                    map.compute(account1, (k, v) -> v - money);
                    map.compute(account2, (k, v) -> v + money);
                    return true;
                }
            }
            return false;
        }


        public boolean deposit(int account, long money) {
            if (account <= map.size()) {
                map.put(account, map.get(account) + money);
                return true;
            }
            return false;
        }

        public boolean withdraw(int account, long money) {
            if (account <= map.size()) {
                long balance = map.get(account);
                if (balance >= money) {
                    map.put(account, balance - money);
                    return true;
                }
            }
            return false;
        }
    }
}
