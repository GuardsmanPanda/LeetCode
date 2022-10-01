package Problem800;

public class Problem838 {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        boolean lastLeft = true;
        int lastIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'L') {
                if (lastLeft) while (++lastIndex <= i) arr[lastIndex] = 'L';
                else {
                    for (int k = 1; k <= (i-lastIndex)/2; k++) {
                        arr[i-k] = 'L';
                        arr[lastIndex+k] = 'R';
                    }
                    if ((i-lastIndex) % 2 == 0) arr[lastIndex + (i-lastIndex)/2] = '.';
                }
                lastLeft = true;
                lastIndex = i;
            }
            else if (c == 'R') {
                if (!lastLeft) while (++lastIndex <= i) arr[lastIndex] = 'R';
                lastLeft = false;
                lastIndex = i;
            }
        }
        if (!lastLeft) while (++lastIndex < arr.length) arr[lastIndex] = 'R';
        return new String(arr);
    }
}
