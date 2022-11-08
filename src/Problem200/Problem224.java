package Problem200;

import java.util.ArrayDeque;

public class Problem224 {
    public int calculate(String s) {
        ArrayDeque<Integer> signStack = new ArrayDeque<>();
        ArrayDeque<Integer> sumStack = new ArrayDeque<>();
        signStack.addFirst(1);
        sumStack.addFirst(0);
        char[] arr = s.toCharArray();
        boolean subtract = false;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '-') subtract = true;
            else if (c == '(') {
                if (subtract) signStack.addFirst(-1);
                else signStack.addFirst(1);
                sumStack.addFirst(0);
                subtract = false;
            }
            else if (c == ')') sumStack.addFirst(signStack.removeFirst()*sumStack.removeFirst() + sumStack.removeFirst());
            else if (c >= '0' && c <= '9') {
                int value = c - '0';
                while (i < arr.length-1 && arr[i+1] >= '0' && arr[i+1] <= '9')
                    value = value*10 + arr[++i] - '0';
                sumStack.addFirst(sumStack.removeFirst() + (subtract ? -value: value));
                subtract = false;
            }
        }
        return sumStack.removeFirst();
    }
}
