package Problem1300;

import java.util.ArrayList;
import java.util.List;

public class Problem1352 {
    class ProductOfNumbers {
        private final List<Integer> products = new ArrayList<>();
        int currentProduct = 1;

        public ProductOfNumbers() {
            products.add(1);
        }

        public void add(int num) {
            currentProduct *= num;
            if (num == 0) {
                products.clear();
                currentProduct = 1;
            }
            products.add(currentProduct);
        }

        public int getProduct(int k) {
            if (k >= products.size()) {
                return 0;
            }
            return currentProduct / products.get(products.size() - k - 1);
        }
    }
}
