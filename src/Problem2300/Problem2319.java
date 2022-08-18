package Problem2300;

public class Problem2319 {
    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (i != j && grid.length - 1 - i != j) {
                        System.out.println("hi");
                        return false;
                    }
                } else {
                    if (i == j || grid.length - 1 - i == j) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
