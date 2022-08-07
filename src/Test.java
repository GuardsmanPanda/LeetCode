public class Test {
    public static void main(String[] args) {
        int[] a = {0,1,0,1,0,1,1,0,1,0,0,0,1,1};
        int m = 2;
        int max = 0;
        for (int left = 0, right = 0; right < a.length; right++) {
            if (a[right] == 0) {
                m--;
            }
            while (m < 0) {
                m += 1 - a[left++];
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
