package backend.models;

public abstract class GoalSetting {
    private String goal;

    public GoalSetting(String goal) {
        this.goal = goal;
    }

    public String getGoal() {
        return goal;
    }

    public abstract String getGoalPlan();
}
