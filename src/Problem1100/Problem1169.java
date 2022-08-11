package Problem1100;

import java.util.*;

public class Problem1169 {
    record Transaction(String name, int amount, int time, String city, String orig) {}

    public List<String> invalidTransactions(String[] transactions) {
        List<Transaction> items = new ArrayList<>();
        for (String transaction : transactions) {
            String[] t = transaction.split(",");
            items.add(new Transaction(t[0], Integer.parseInt(t[2]), Integer.parseInt(t[1]), t[3], transaction));
        }
        Map<String, List<Transaction>> nameMap = new HashMap<>(transactions.length);
        List<String> result = new ArrayList<>();
        for (Transaction item : items) {
            nameMap.computeIfAbsent(item.name, k -> new ArrayList<>()).add(item);
        }

        for (List<Transaction> value : nameMap.values()) {
            for (Transaction t1 : value) {
                if (t1.amount > 1000) {
                    result.add(t1.orig);
                    continue;
                }
                for (Transaction t2 : value) {
                    if (!t1.city.equals(t2.city) && Math.abs(t1.time - t2.time) <= 60) {
                        result.add(t1.orig);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
