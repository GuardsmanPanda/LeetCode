package Problem1600;

public class Problem1689 {
    public int minPartitions(String n) {
        return n.chars().map(c -> c - '0').max().orElse(0);
    }
}
