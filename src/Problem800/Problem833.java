package Problem800;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        String[] arr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.substring(i,i+1);
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            String word = sources[i];
            if (index+word.length() > s.length() || !word.equals(s.substring(index, index+word.length()))) //terribly slow
                continue;
            for (int k = 0; k < word.length(); k++)
                arr[index+k] = "";
            arr[index] = targets[i];
        }
        return String.join("", arr);
    }
}
