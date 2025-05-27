package backend.models;

public class RankCalculator {
    // variables for all kinds of reps
    private int pushUps;
    private int pullUps;
    private int squats;
    private int burpees;
    private int lunges;
    private int sitUps;

    public RankCalculator(int pushUps, int pullUps, int squats, int burpees, int lunges, int sitUps) {
        this.pushUps = Math.max(0, pushUps);
        this.pullUps = Math.max(0, pullUps);
        this.squats = Math.max(0, squats);
        this.burpees = Math.max(0, burpees);
        this.lunges = Math.max(0, lunges);
        this.sitUps = Math.max(0, sitUps);
    }

    public int getTotalReps() {
        return pushUps + pullUps + squats + burpees + lunges + sitUps;
    }
}
