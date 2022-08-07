package Special;

import java.util.*;

public class FoodRatings {
    private final Map<String, PriorityQueue<int[]>> mqq = new HashMap<>();
    private final Map<String, Integer> foodMap = new HashMap<>();
    private final String[] cuisines;
    private final String[] foods;
    private final int[] seqNumber;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            mqq.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>((a1, a2) -> a1[1] == a2[1] ? foods[a1[0]].compareTo(foods[a2[0]]) : a2[1] - a1[1]))
                    .add(new int[] {i, ratings[i], 0});
            foodMap.put(foods[i], i);
        }
        seqNumber = new int[foods.length];
        this.cuisines = cuisines;
        this.foods = foods;
    }

    public void changeRating(String food, int newRating) {
        int foodIdx = foodMap.get(food);
        mqq.get(cuisines[foodIdx]).add(new int[] {foodIdx, newRating, ++seqNumber[foodIdx]});
    }

    public String highestRated(String cuisine) {
        var q = mqq.get(cuisine);
        var res = q.peek();
        while (res[2] != seqNumber[res[0]]) {
            q.remove();
            res = q.peek();
        }
        return foods[res[0]];
    }
}
