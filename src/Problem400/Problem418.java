package Problem400;

public class Problem418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        for (String s : sentence) {
            if (s.length() > cols) {
                return 0;
            }
        }
        char[] arr = (String.join(" ", sentence) + " ").toCharArray();
        int pos = 0;
        for (int i = 0; i < rows; i++) {
            pos += cols;
            System.out.println("pos: " + pos);
            if (arr[pos % arr.length] == ' ') {
                pos++;
            }
            while (arr[(pos - 1) % arr.length] != ' ') {
                pos--;
            }
            System.out.println("pos2: " + pos);
        }
        return pos / arr.length;
    }
}
