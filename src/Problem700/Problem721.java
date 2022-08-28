package Problem700;

import java.util.*;

public class Problem721 {
    record Account(String name, HashSet<String> emails) {}

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parent = new int[accounts.size() * 10];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Map<String, Integer> emailToIndex = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0) + i;
            int ndx = emailToIndex.computeIfAbsent(name, k -> emailToIndex.size());
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                int edx = emailToIndex.computeIfAbsent(email, k -> emailToIndex.size());
                int p1 = find(parent, ndx);
                int p2 = find(parent, edx);
                if (p1 != p2) {
                    parent[p1] = p2;
                }
            }
        }
        Map<Integer, Account> indexToEmails = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            int ndx = emailToIndex.get(name + i);
            int p = find(parent, ndx);
            Account acc = indexToEmails.computeIfAbsent(p, k -> new Account(name, new HashSet<>()));
            for (int j = 1; j < account.size(); j++) {
                acc.emails.add(account.get(j));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Account acc : indexToEmails.values()) {
            List<String> emails = new ArrayList<>(acc.emails);
            Collections.sort(emails);
            emails.add(0, acc.name);
            res.add(emails);
        }
        return res;
    }

    private int find(int[] parent, int i) {
        return parent[i] == i ? i : (parent[i] = find(parent, parent[i]));
    }
}
