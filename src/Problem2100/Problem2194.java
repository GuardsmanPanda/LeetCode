package Problem2100;

import java.util.ArrayList;
import java.util.List;

public class Problem2194 {
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = {s.charAt(0), s.charAt(1)};
        while (arr[0] <= s.charAt(2)) {
            arr[1] = s.charAt(1);
            System.out.println(arr[0] + " " + arr[1]);
            while (arr[1] <= s.charAt(3)) {

                res.add(new String(arr));
                arr[1]++;
            }
            arr[0]++;
        }
        return res;
    }
}
