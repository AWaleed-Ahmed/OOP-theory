package backend.models;

public class CaloriesCounter {
    private String itemName;
    private int quantity;
    private double caloriesPerUnit;

    public CaloriesCounter(String itemName, int quantity, double caloriesPerUnit) {
        this.itemName = itemName.toLowerCase();
        this.quantity = quantity;
        this.caloriesPerUnit = caloriesPerUnit;
    }

    public double getTotalCalories() {
        return caloriesPerUnit * quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCaloriesPerUnit() {
        return caloriesPerUnit;
    }
}


//package backend.models;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class CalorieCalculator {
//
//    private final HashMap<String, Double> foodCalorie = new HashMap<>();
//    private double totalCalories = 0.0;
//    private String selectedGoal;
//
//    // Static map for external calorie access
//    public static final Map<String, Double> staticCalorieMap = new HashMap<>();
//
//    public CalorieCalculator() {
//        settingCalorie();
//    }
//
//
//    private void settingCalorie() {
//        foodCalorie.put("rice", 1.3);    // calculating per gram calroies of each item
//        foodCalorie.put("chicken", 2.4);
//        foodCalorie.put("beef", 2.5);
//        foodCalorie.put("wheatGrain", 3.4);
//        foodCalorie.put("milk", 103.0);
//        foodCalorie.put("chickpeas", 1.6);
//        foodCalorie.put("kidneyBeans", 1.3);
//        foodCalorie.put("banana", 1.1);
//        foodCalorie.put("egg", 90.0);
//        foodCalorie.put("mutton", 3.0);
//        foodCalorie.put("oats", 3.9);
//        foodCalorie.put("peanutButter", 6.0);
//
//        // Populate the static map with same values
//        staticCalorieMap.putAll(foodCalorie);
//    }
//    public static Map<String, Double> getStaticCalorieMap() {
//        return staticCalorieMap;
//    }
//
//
//    public void addFoodItem(String itemName, int grams, Double customCalories) {
//        itemName = itemName.toLowerCase();
//        double caloriePerGram;
//
//        if (foodCalorie.containsKey(itemName)) {
//            caloriePerGram = foodCalorie.get(itemName);
//        } else if (customCalories != null) {
//            caloriePerGram = customCalories;
//        } else {
//            caloriePerGram = 0;
//        }
//
//        double itemCalories = caloriePerGram * grams;
//        totalCalories += itemCalories;
//    }
//
////    public void setGoal(String goal) {
////        this.selectedGoal = goal.toLowerCase();
////    }
////
////    public String getSelectedGoal() {
////        return selectedGoal;
////    }
////
//    public double getTotalCalories() {
//        return totalCalories;
//    }
//
//    public String suggestPlanBasedOnBMIAndGoal(double bmi) {
//        String bmiTip;
//        String goal = selectedGoal != null ? selectedGoal : "";
//
//        // BMICalculator-based tip
//        if (bmi < 18.5) {
//            bmiTip = "🌱 Skinny Fuel (BMICalculator <18.5)\nEat big, lift heavy, sleep tight - 500 extra calories = 1lb/week gains.";
//        } else if (bmi < 25) {
//            bmiTip = "⚡️ Prime Physique (BMICalculator 18.5-25)\nEat smart, train sharp, stay balanced - maintenance is your playground.";
//        } else if (bmi < 30) {
//            bmiTip = "✂️ Cut Crew (BMICalculator 25-30)\nLess junk, more iron - 300 deficit + 4x sweat = 1lb fat loss/week.";
//        } else if (bmi < 35) {
//            bmiTip = "🏔️ Heavy Hitters (BMICalculator 30-35)\nSwap soda for water, walk daily, protein first - 5% body change in 12 weeks.";
//        } else {
//            bmiTip = "💥 Transform Tier (BMICalculator 35+)\nSmall wins stack up - 10min daily movement + veggie swaps = 1% body change/month.";
//        }
//
//        // Append goal-specific advice
//        String goalAdvice = switch (goal) {
//            case "cut", "lose weight" -> "➤ Lower your intake by 500 kcal/day.\n➤ Focus on lean protein, veggies, and whole grains.";
//            case "maintain", "maintain weight" -> "➤ Maintain current intake.\n➤ Eat balanced meals and stay active.";
//            case "bulk", "gain muscle" -> "➤ Increase intake by 300–500 kcal/day.\n➤ Prioritize protein, complex carbs, and strength training.";
//            case "improve endurance" -> "➤ Add complex carbs and hydration-focused meals.\n➤ Long cardio and recovery matter.";
//            case "general fitness" -> "➤ Eat a variety of nutrient-dense foods.\n➤ Stay consistent with exercise.";
//            default -> "Please select a valid goal.";
//        };
//
//        return "Your BMICalculator: " + bmi + "\n\n" + bmiTip + "\n\n" + "Goal-based advice:\n" + goalAdvice;
//    }
//
//    // Static method for SceneController to use calorie values easily
//    public static int getCaloriesFromMap(String food, int grams) {
//        if (food == null || food.isEmpty()) return 0;
//        food = food.toLowerCase();
//        Double calPerGram = staticCalorieMap.get(food);
//        if (calPerGram == null) return 0;
//        return (int) (calPerGram * grams);
//    }
//}
