package Problem1300;

public class Problem1342 {
    public int numberOfSteps(int num) {
        return num == 0 ? 0 : (num % 2 == 0 ? numberOfSteps(num / 2) : numberOfSteps(num - 1)) + 1;
    }
}
