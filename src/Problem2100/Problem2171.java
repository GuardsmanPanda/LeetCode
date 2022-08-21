package Problem2100;

import java.util.Arrays;

public class Problem2171 {
    public long minimumRemoval(int[] beans) {
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        Arrays.sort(beans);
        long ans = sum;
        for (int i = 0; i < beans.length; i++) {
            long remainLen = beans.length - i;
            long remainBeans = remainLen * beans[i];
            ans = Math.min(ans, sum - remainBeans);
        }
        return ans;
    }
}
