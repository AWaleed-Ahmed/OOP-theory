package backend.services;

public class RankCalculatorService {

    public static String getRank(int totalReps) {
        if (totalReps >= 200) return "Elite";
        if (totalReps >= 150) return "Advanced";
        if (totalReps >= 100) return "Intermediate";
        if (totalReps >= 50) return "Beginner";
        return "Novice";
    }

    public static String getSuggestion(String rank) {
        return switch (rank) {
            case "Elite" -> "Train smart and heavy, track progress weekly, and guide others who admire your discipline.";
            case "Advanced" -> "Focus on muscle symmetry, optimize rest days, and start refining your diet for lean gains.";
            case "Intermediate" -> "Incorporate progressive overload, maintain proper form, and start exploring compound lifts with supervision.";
            case "Beginner" -> "Build a consistent weekly routine, focus on form, and gradually increase intensity to avoid burnout.";
            case "Novice" -> "Start with body weight exercises, hydrate well, set small goals, and stay patient through the beginning phase.";
            default -> "You got this, keep moving!";
        };
    }
}

