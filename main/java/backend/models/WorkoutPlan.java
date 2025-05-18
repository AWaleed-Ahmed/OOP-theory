package backend.models;

public class WorkoutPlan {
    private int pushUps;
    private int pullUps;
    private int squats;
    private int lunges;
    private int burpees;
    private int sitUps;
    private int running; // running is considered in "reps" (e.g., km)

    private int totalExercises;
    private int totalReps;

    // Setters sare
    public void setPushUps(int pushUps) {
        this.pushUps = Math.max(pushUps, 0);
    }

    public void setPullUps(int pullUps) {
        this.pullUps = Math.max(pullUps, 0);
    }

    public void setSquats(int squats) {
        this.squats = Math.max(squats, 0);
    }

    public void setLunges(int lunges) {
        this.lunges = Math.max(lunges, 0);
    }

    public void setBurpees(int burpees) {
        this.burpees = Math.max(burpees, 0);
    }

    public void setSitUps(int sitUps) {
        this.sitUps = Math.max(sitUps, 0);
    }

    public void setRunning(int running) {
        this.running = Math.max(running, 0);
    }

    // Getters sare
    public int getPushUps() { return pushUps; }
    public int getPullUps() { return pullUps; }
    public int getSquats() { return squats; }
    public int getLunges() { return lunges; }
    public int getBurpees() { return burpees; }
    public int getSitUps() { return sitUps; }
    public int getRunning() { return running; }
    public int getTotalExercises() { return totalExercises; }
    public int getTotalReps() { return totalReps; }


    public void analyzeWorkout() {
        totalExercises = 0;
        totalReps = 0;

        if (pushUps > 0) {
            totalExercises++;
            totalReps += pushUps;
        }
        if (pullUps > 0) {
            totalExercises++;
            totalReps += pullUps;
        }
        if (squats > 0) {
            totalExercises++;
            totalReps += squats;
        }
        if (lunges > 0) {
            totalExercises++;
            totalReps += lunges;
        }
        if (burpees > 0) {
            totalExercises++;
            totalReps += burpees;
        }
        if (sitUps > 0) {
            totalExercises++;
            totalReps += sitUps;
        }
        if (running > 0) {
            totalExercises++;
            totalReps += running;
        }
    }


    public static String getRank(int totalReps) {
        if (totalReps >= 200) return "Elite";
        if (totalReps >= 150) return "Advanced";
        if (totalReps >= 100) return "Intermediate";
        if (totalReps >= 50) return "Beginner";
        return "Novice";
    }


    public static String getSuggestion(String rank) {
        return switch (rank) {
            case "Elite" -> "GET YOURSELF A GYM BRO";
            case "Advanced" -> "You’re killing it! Stay consistent.";
            case "Intermediate" -> "Great work! Try adding resistance training.";
            case "Beginner" -> "Try to gradually increase your reps.";
            case "Novice" -> "Start small, build discipline!";
            default -> "Keep moving!";
        };
    }
}
