package Problem;

import java.util.ArrayList;
import java.util.List;

public class Problem30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return new ArrayList<>();
        int prime = 111317, size = words[0].length(), diff = 0;
        int[] count = new int[prime];
        for (String word : words) {
            int hash = 0;
            for (char c : word.toCharArray())
                hash = (hash * 137 + c) % prime;
            if (count[hash]++ == 0) diff++;
        }

        int[] rollingHash = new int[s.length()-size+1];
        char[] arr = s.toCharArray();
        int rollHash = 0, mul = 1;
        for (int i = 0; i < size-1; i++, mul = (mul*137)%prime)
            rollHash = (rollHash + arr[size-2-i]*mul) % prime;
        for (int i = size-1; i < arr.length; i++) {
            rollingHash[i-size+1] = rollHash = (rollHash*137 + arr[i]) % prime;
            rollHash = (rollHash -(arr[i-size+1]*mul % prime) + prime) % prime;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int idx = i;
            for (int k = 0; k < words.length-1; k++, idx += size) {
                int val = count[rollingHash[idx]]--;
                if (val == 1) diff--;
                if (val == 0) diff++;
            }
            for (;idx < rollingHash.length; idx += size) {
                int val = count[rollingHash[idx]]--;
                if (val == 1) diff--;
                if (val == 0) diff++;
                if (diff == 0) result.add(idx - size*(words.length-1));
                val = count[rollingHash[idx - size*(words.length-1)]]++;
                if (val == -1) diff--;
                if (val == 0) diff++;
            }
            for (int ndx = idx - size*(words.length-1); ndx < rollingHash.length; ndx += size) {
                int val = count[rollingHash[ndx]]++;
                if (val == -1) diff--;
                if (val == 0) diff++;
            }
        }
        return result;
    }
}
