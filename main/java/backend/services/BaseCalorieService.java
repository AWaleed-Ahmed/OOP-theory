package backend.services;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseCalorieService {
    protected final Map<String, Double> calorieMap = new HashMap<>();

    public BaseCalorieService() {
        initializeCalories();
    }

    protected void initializeCalories() {
        calorieMap.put("rice", 1.3);
        calorieMap.put("chicken", 2.4);
        calorieMap.put("beef", 2.5);
        calorieMap.put("wheatgrains", 3.4);
        calorieMap.put("milk", 103.0);
        calorieMap.put("chickpeas", 1.6);
        calorieMap.put("kidneybeans", 1.3);
        calorieMap.put("banana", 1.1);
        calorieMap.put("egg", 90.0);
        calorieMap.put("mutton", 3.0);
        calorieMap.put("oats", 3.9);
        calorieMap.put("peanutbutter", 6.0);
    }

    public double getCalories(String itemName, int grams) {
        Double perGram = calorieMap.get(itemName.toLowerCase());
        return perGram != null ? perGram * grams : 0;
    }

    public boolean containsFood(String itemName) {
        return calorieMap.containsKey(itemName.toLowerCase());
    }
}
