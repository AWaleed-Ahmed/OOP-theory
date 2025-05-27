package backend.services;

import backend.models.GoalSetting;

public class GoalSettingService {

    public static GoalSetting createGoalSetting(String selectedGoal) {
        return switch (selectedGoal.toLowerCase()) {
            case "lose weight" -> new Goal("Lose weight");
            case "gain muscle" -> new Goal("Gain muscle");
            case "maintain weight" -> new Goal("Maintain weight");
            case "improve endurance" -> new Goal("Improve endurance");
            case "general fitness" -> new Goal("General fitness");
            default -> new Goal("Unknown goal");
        };
    }

    // Nested class to demonstrate polymorphic behavior
    private static class Goal extends GoalSetting {
        public Goal(String goal) {
            super(goal);
        }

        @Override
        public String getGoalPlan() {
            return "Plan for: " + getGoal();  // Stub for actual plan logic
        }
    }
}

