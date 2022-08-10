package Problem400;

import java.util.List;

public class Problem364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        return dfs(nestedList, 1, getMaxDepth(nestedList));
    }

    private int getMaxDepth(List<NestedInteger> nestedList) {
        int maxDepth = 0;
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger()) {
                maxDepth = Math.max(maxDepth, 1 + getMaxDepth(ni.getList()));
            }
            if (ni.isInteger()) {
                maxDepth = Math.max(maxDepth, 1);
            }
        }
        return maxDepth;
    }

    private int dfs(List<NestedInteger> nestedList, int depth, int maxDepth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * (maxDepth - depth + 1);
            } else {
                sum += dfs(ni.getList(), depth + 1, maxDepth);
            }
        }
        return sum;
    }

    public interface NestedInteger {
        // Constructor initializes an empty nested list.

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
