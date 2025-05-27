package backend.controllers;

import backend.models.GoalSetting;
import backend.services.GoalSettingService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GoalSettingController {

    private void goToNextScene(ActionEvent event, String selectedGoal) {
        GoalSetting userGoal = GoalSettingService.createGoalSetting(selectedGoal);
        System.out.println("Selected Goal: " + userGoal.getGoalPlan()); // Debug/Placeholder

        switchScene(event, "/frontend/Scene6.fxml"); // Update path if needed
    }

    @FXML
    private void switchToScene6(ActionEvent event) {
        Button clicked = (Button) event.getSource();
        String goalText = clicked.getText();
        goToNextScene(event, goalText);
    }

    private void switchScene(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

