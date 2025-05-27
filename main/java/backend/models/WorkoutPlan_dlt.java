//package backend.models;
//
//
//import backend.SceneController;
//import backend.models.*;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.Parent;
//import javafx.event.ActionEvent;
//import javafx.scene.control.*;
//import java.io.IOException;
//public class WorkoutPlan {
//    // Workout Ranking System
//    private Stage stage;
//    private Scene scene;
//    @FXML private TextField pushupsField, pullupsField, squatsField, burpeesField, lungesField, situpsField;
//    @FXML private Label rankLabel, suggestionLabel;
//
//    @FXML
//    public void switchToScene9(ActionEvent event) throws IOException {
//        int pushups = parseInput(pushupsField.getText());
//        int pullups = parseInput(pullupsField.getText());
//        int squats = parseInput(squatsField.getText());
//        int burpees = parseInput(burpeesField.getText());
//        int lunges = parseInput(lungesField.getText());
//        int situps = parseInput(situpsField.getText());
//
//        int totalReps = pushups + pullups + squats + burpees + lunges + situps;
//
//        String rank = WorkoutPlan.getRank(totalReps);
//        String suggestion = WorkoutPlan.getSuggestion(rank);
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/Rank+Suggestions.fxml"));
//        Parent root = loader.load();
//
////        SceneController controller = loader.getController();
//        setRankAndSuggestion(rank, suggestion);
//
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    private int parseInput(String text) {
//        try {
//            return Integer.parseInt(text.trim());
//        } catch (NumberFormatException e) {
//            return 0;
//        }
//    }
//
//    public void setRankAndSuggestion(String rank, String suggestion) {
//        if (rankLabel != null) rankLabel.setText("Rank: " + rank);
//        if (suggestionLabel != null) suggestionLabel.setText(suggestion);
//    }
//
////    private int pushUps;
////    private int pullUps;
////    private int squats;
////    private int lunges;
////    private int burpees;
////    private int sitUps;
//
////    private int totalExercises;
////    private int totalReps;
////
////    // All Setters
////    public void setPushUps(int pushUps) {
////        this.pushUps = Math.max(pushUps, 0);
////    }
////
////    public void setPullUps(int pullUps) {
////        this.pullUps = Math.max(pullUps, 0);
////    }
////
////    public void setSquats(int squats) {
////        this.squats = Math.max(squats, 0);
////    }
////
////    public void setLunges(int lunges) {
////        this.lunges = Math.max(lunges, 0);
////    }
////
////    public void setBurpees(int burpees) {
////        this.burpees = Math.max(burpees, 0);
////    }
////
////    public void setSitUps(int sitUps) {
////        this.sitUps = Math.max(sitUps, 0);
////    }
//
//    // All Getters
////    public int getPushUps() { return pushUps; }
////    public int getPullUps() { return pullUps; }
////    public int getSquats() { return squats; }
////    public int getLunges() { return lunges; }
////    public int getBurpees() { return burpees; }
////    public int getSitUps() { return sitUps; }
////    public int getTotalExercises() { return totalExercises; }
////    public int getTotalReps() { return totalReps; }
//
//
////    public void analyzeWorkout() {
////        totalExercises = 0;
////        totalReps = 0;
////
////        if (pushUps > 0) {
////            totalExercises++;
////            totalReps += pushUps;
////        }
////        if (pullUps > 0) {
////            totalExercises++;
////            totalReps += pullUps;
////        }
////        if (squats > 0) {
////            totalExercises++;
////            totalReps += squats;
////        }
////        if (lunges > 0) {
////            totalExercises++;
////            totalReps += lunges;
////        }
////        if (burpees > 0) {
////            totalExercises++;
////            totalReps += burpees;
////        }
////        if (sitUps > 0) {
////            totalExercises++;
////            totalReps += sitUps;
////        }
////    }
//
//
//    public static String getRank(int totalReps) {
//        if (totalReps >= 200) return "Elite";
//        if (totalReps >= 150) return "Advanced";
//        if (totalReps >= 100) return "Intermediate";
//        if (totalReps >= 50) return "Beginner";
//        return "Novice";
//    }
//
//
//    public static String getSuggestion(String rank) {
//        return switch (rank) {
//            case "Elite" -> "\"Train smart and heavy, track progress weekly, and guide others who admire your discipline.\"";
//            case "Advanced" -> "\"Focus on muscle symmetry, optimize rest days, and start refining your diet for lean gains.\"";
//            case "Intermediate" -> "\"Incorporate progressive overload, maintain proper form, and start exploring compound lifts with supervision.\"";
//            case "Beginner" -> "\"Build a consistent weekly routine, focus on form, and gradually increase intensity to avoid burnout.\"";
//            case "Novice" -> "\"Start with body weight exercises, hydrate well, set small goals, and stay patient through the beginning phase.\"";
//            default -> "You got this, Keep moving!";
//        };
//    }
//}
