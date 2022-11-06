package Problem300;

public class Problem345 {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length-1;
        while (true) {
            while (left < s.length() && arr[left] != 'a' && arr[left] != 'e' && arr[left] != 'u' && arr[left] != 'i' && arr[left] != 'o'
                    && arr[left] != 'A' && arr[left] != 'E' && arr[left] != 'U' && arr[left] != 'I' && arr[left] != 'O')
                left++;
            if (left == s.length() || left >= right) break;
            while (arr[right] != 'a' && arr[right] != 'e' && arr[right] != 'u' && arr[right] != 'i' && arr[right] != 'o'
                    && arr[right] != 'A' && arr[right] != 'E' && arr[right] != 'U' && arr[right] != 'I' && arr[right] != 'O')
                right--;
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++; right--;
        }
        return new String(arr);
    }
}
