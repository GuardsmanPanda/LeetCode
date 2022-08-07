public class Problem1899 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            found[0] |= triplet[0] == target[0];
            found[1] |= triplet[1] == target[1];
            found[2] |= triplet[2] == target[2];
            if (found[0] && found[1] && found[2]) {
                return true;
            }
        }
        return found[0] && found[1] && found[2];
    }
}
