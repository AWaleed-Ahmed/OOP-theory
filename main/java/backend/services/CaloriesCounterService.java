package backend.services;

import backend.models.CaloriesCounter;

import java.util.ArrayList;
import java.util.List;

public class CaloriesCounterService extends BaseCalorieService {

    private final List<CaloriesCounter> foodItems = new ArrayList<>();

    public void addCustomFood(String itemName, int quantity, double caloriesPerUnit) {
        CaloriesCounter item = new CaloriesCounter(itemName, quantity, caloriesPerUnit);
        foodItems.add(item);
    }

    public double calculateTotalCalories() {
        return foodItems.stream().mapToDouble(CaloriesCounter::getTotalCalories).sum();
    }

    public List<CaloriesCounter> getAllItems() {
        return new ArrayList<>(foodItems);
    }

    public void clearItems() {
        foodItems.clear();
    }
}
